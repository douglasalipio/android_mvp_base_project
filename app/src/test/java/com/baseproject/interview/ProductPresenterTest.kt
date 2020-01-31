package com.baseproject.interview

import com.baseproject.interview.data.AppDataSource
import com.baseproject.interview.feature.product.ProductContract
import com.baseproject.interview.feature.product.ProductInteractor
import com.baseproject.interview.feature.product.ProductPresenter
import com.nhaarman.mockitokotlin2.capture
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mock
import org.mockito.MockitoAnnotations


class ProductPresenterTest {
    @Mock
    private lateinit var appRepository: AppDataSource
    @Mock
    private lateinit var view: ProductContract.View
    @Mock
    private lateinit var interactor: ProductContract.Interactor
    @Captor
    private lateinit var getProductCallbackCaptor: ArgumentCaptor<ProductInteractor.GetFeatureCallback>
    private lateinit var presenter: ProductPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter =
            ProductPresenter(interactor)
        presenter.takeView(view)
    }

    @Test
    fun `should return a list of features`() {
        presenter.loadData()
        verify(interactor).requestData(capture(getProductCallbackCaptor))
        getProductCallbackCaptor.value.onFeatureLoaded(mockProductDto())
        verify(view).showData(mockProductDto())
    }

    @Test
    fun `should show a error message`() {
        presenter.loadData()
        verify(interactor).requestData(capture(getProductCallbackCaptor))
        getProductCallbackCaptor.value.onDataNotAvailable("data not available.")
        verify(view).showDataError()
    }
}