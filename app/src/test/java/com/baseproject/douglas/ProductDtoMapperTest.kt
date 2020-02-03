package com.baseproject.douglas

import com.baseproject.douglas.data.feature.product.ProductDtoMapper
import org.hamcrest.CoreMatchers.hasItem
import org.junit.Assert.assertThat
import org.junit.Test

class ProductDtoMapperTest {

    private val mapper = ProductDtoMapper()

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
