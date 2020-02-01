package com.baseproject.interview.productDetail

import com.baseproject.interview.data.feature.productDetail.ProductDetailDtoMapper
import com.baseproject.interview.mockProductDetail
import com.baseproject.interview.mockProductDetailDto
import org.junit.Assert.assertEquals
import org.junit.Test

class ProductDetailMapperTest {

    private val mapper = ProductDetailDtoMapper()

    @Test
    fun `should map section model to section`() {
        // given
        val productDetailDto = mockProductDetailDto()
        val expectedProductDetail = mockProductDetail()
        // when
        val mappingResult = mapper.map(productDetailDto)
        // then
        assertEquals(expectedProductDetail.id, mappingResult.id)
        assertEquals(expectedProductDetail.allergyInformation, mappingResult.allergyInformation)
        assertEquals(expectedProductDetail.description, mappingResult.description)
        assertEquals(expectedProductDetail.imageUrl, mappingResult.imageUrl)
        assertEquals(expectedProductDetail.title, mappingResult.title)

    }

}
