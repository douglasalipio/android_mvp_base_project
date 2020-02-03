package com.baseproject.douglas

import com.baseproject.douglas.feature.product.ProductContract
import com.baseproject.douglas.feature.product.ProductInteractor
import com.baseproject.douglas.feature.product.ProductPresenter
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.capture
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test
import org.mockito.*
import org.mockito.ArgumentMatchers.anyString


class ProductPresenterTest {
    @Mock
    private lateinit var view: ProductContract.View
    @Mock
    private lateinit var interactor: ProductContract.Interactor
    @Captor
    private lateinit var getProductCallbackCaptor: ArgumentCaptor<ProductInteractor.GetProductCallback>
    @Captor
    private lateinit var getProductDetailCallbackCaptor: ArgumentCaptor<ProductInteractor.GetProductDetailCallback>
    private lateinit var presenter: ProductPresenter
    private val clickProductDetail: (String) -> Unit = {}

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = ProductPresenter(interactor)
        presenter.takeView(view)
    }

    @Test
    fun `should return a list of sections`() {
        presenter.loadData()
        presenter.mapProductItems(mockProducts(), clickProductDetail)

        verify(interactor).requestProducts(capture(getProductCallbackCaptor))
        getProductCallbackCaptor.value.onProductLoaded(mockProducts())

        verify(view).setUpGridList(1, mockProducts())
        verify(view).showProducts(any())
    }

    @Test
    fun `should show a error message after loading productDetail`() {
        presenter.loadProductDetail("id")
        verify(interactor).requestProductDetail(capture(getProductDetailCallbackCaptor), anyString())
        getProductDetailCallbackCaptor.value.onDataNotAvailable("data not available.")
        verify(view).showDataError()
    }

    @Test
    fun `should show a error message after loading products`() {
        presenter.loadData()
        verify(interactor).requestProducts(capture(getProductCallbackCaptor))
        getProductCallbackCaptor.value.onDataNotAvailable("data not available.")
        verify(view).showDataError()
    }
}