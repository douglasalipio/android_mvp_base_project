package com.baseproject.interview.productDetail

import com.baseproject.interview.feature.productdetail.ProductDetailContract
import com.baseproject.interview.feature.productdetail.ProductDetailInteractor
import com.baseproject.interview.feature.productdetail.ProductDetailPresenter
import com.baseproject.interview.mockProductDetail
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.capture
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class ProductDetailPresenterTest {
    @Mock
    private lateinit var view: ProductDetailContract.View
    @Mock
    private lateinit var interactor: ProductDetailContract.Interactor
    @Captor
    private lateinit var getProductDetailCallbackCaptor: ArgumentCaptor<ProductDetailInteractor.GetProductDetailCallback>
    private lateinit var presenter: ProductDetailPresenter


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter =
            ProductDetailPresenter(interactor)
        presenter.takeView(view)
    }

    @Test
    fun `should return a list of features`() {
        presenter.loadProductDetail("id")

        verify(interactor).requestData(capture(getProductDetailCallbackCaptor), any())
        getProductDetailCallbackCaptor.value.onProductDetailLoaded(mockProductDetail())

        verify(view).showProductDetail(mockProductDetail())
    }

    @Test
    fun `should show a error message`() {
        presenter.loadProductDetail("id")
        verify(interactor).requestData(capture(getProductDetailCallbackCaptor), any())
        getProductDetailCallbackCaptor.value.onDataNotAvailable("data not available.")
        verify(view).showDataError()
    }
}