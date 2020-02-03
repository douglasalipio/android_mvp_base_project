package com.baseproject.douglas.feature.product


import com.baseproject.douglas.di.ActivityScoped
import com.baseproject.douglas.feature.product.data.Product
import com.baseproject.douglas.feature.product.data.ProductDetail
import com.baseproject.douglas.feature.product.extensions.mapToProductGroup
import com.baseproject.douglas.feature.product.view.ProductHeader
import com.xwray.groupie.Section
import javax.inject.Inject

@ActivityScoped
class ProductPresenter @Inject constructor(private val interactor: ProductContract.Interactor) :
    ProductContract.Presenter {

    private var view: ProductContract.View? = null

    override fun <T> takeView(view: T) {
        this.view = view as ProductContract.View
    }

    override fun loadData() {
        interactor.requestProducts(object : ProductInteractor.GetProductCallback {

            override fun onProductLoaded(data: Product) {
                calculateTotalOfProducts(data)
            }

            override fun onDataNotAvailable(strError: String) {
                view?.showDataError()
            }
        })
    }

    override fun loadProductDetail(productId: String) {
        interactor.requestProductDetail(object : ProductInteractor.GetProductDetailCallback {

            override fun onProductDetailLoaded(data: List<ProductDetail>) {
                view?.showProductDetail(data.first { it.id == productId })
            }

            override fun onDataNotAvailable(strError: String) {
                view?.showDataError()
            }
        }, productId)
    }

    private fun calculateTotalOfProducts(data: Product) {
        val totalItems = data.categories.map { it.subItems.size }.sum()
        view?.setUpGridList(totalItems, data)
    }

    override fun mapProductItems(data: Product, clickProductDetail: (String) -> Unit) {
        data.categories.forEach { category ->
            val section = Section(ProductHeader(category.tag))
            val group = category.subItems.mapToProductGroup(clickProductDetail)
            section.add(group)
            view?.showProducts(section)
        }
    }

    override fun dropView() {
        view = null
    }
}