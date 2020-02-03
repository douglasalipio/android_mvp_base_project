package com.baseproject.douglas

import com.baseproject.douglas.data.feature.productDetail.ProductDetailDtoMapper
import org.hamcrest.CoreMatchers.hasItem
import org.junit.Assert.assertThat
import org.junit.Test

class ProductDetailMapperTest {

    private val mapper = ProductDetailDtoMapper()

    @Test
    fun `should map section model to section`() {
        // given
        val productDetailDto = listOf(mockProductDetailDto())
        val expectedProductDetail = mockProductDetail()
        // when
        val mappingResult = mapper.map(productDetailDto)
        // then
        assertThat(mappingResult, hasItem((expectedProductDetail)))
    }

}
