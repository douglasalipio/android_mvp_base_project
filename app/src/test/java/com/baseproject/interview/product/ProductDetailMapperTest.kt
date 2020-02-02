package com.baseproject.interview.product

import com.baseproject.interview.data.feature.productDetail.ProductDetailDtoMapper
import com.baseproject.interview.mockProductDetail
import com.baseproject.interview.mockProductDetailDto
import com.baseproject.interview.mockProductDetails
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.hasItem
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Test

class ProductDetailMapperTest {

    private val mapper = ProductDetailDtoMapper()

    @Test
    fun `should map section model to section`() {
        // given
        val productDetailDto = mockProductDetailDto()
        val expectedProductDetail = mockProductDetail()
        // when
        val mappingResult = mapper.map(listOf(mockProductDetailDto()))
        // then
        assertThat(mappingResult, hasItem((expectedProductDetail)))
    }

}
