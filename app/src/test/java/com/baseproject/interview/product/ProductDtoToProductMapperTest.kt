package com.baseproject.interview.product

import com.baseproject.interview.data.feature.product.ProductDtoToProductMapper
import com.baseproject.interview.mockProductDto
import com.baseproject.interview.mockProducts
import org.hamcrest.CoreMatchers.hasItem
import org.junit.Assert.assertThat
import org.junit.Test

class ProductDtoToProductMapperTest {

    private val mapper = ProductDtoToProductMapper()

    @Test
    fun `should map section model to section`() {
        // given
        val productDto = mockProductDto()
        val expectedProduct = mockProducts()
        // when
        val mappingResult = mapper.map(productDto)
        // then
        assertThat(mappingResult.categories, hasItem((expectedProduct.categories.last())))
    }

}
