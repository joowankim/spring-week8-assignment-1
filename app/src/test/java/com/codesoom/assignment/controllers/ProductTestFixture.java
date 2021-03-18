package com.codesoom.assignment.controllers;

import org.springframework.restdocs.headers.RequestHeadersSnippet;
import org.springframework.restdocs.payload.RequestFieldsSnippet;
import org.springframework.restdocs.payload.ResponseFieldsSnippet;
import org.springframework.restdocs.request.PathParametersSnippet;

import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.requestHeaders;
import static org.springframework.restdocs.payload.JsonFieldType.NUMBER;
import static org.springframework.restdocs.payload.JsonFieldType.STRING;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.restdocs.snippet.Attributes.key;

public class ProductTestFixture {
    public static PathParametersSnippet getProductPathParametersSnippet() {
        return pathParameters(
                parameterWithName("id").description("상품 아이디")
        );
    }

    public static RequestHeadersSnippet getProductRequestHeadersSnippet() {
        return requestHeaders(headerWithName("Authorization").description("인증 토큰"));
    }

    public static RequestFieldsSnippet getProductDataRequestFields() {
        return requestFields(
                fieldWithPath("name").type(STRING).description("상품 이름")
                        .attributes(key("constraints").value("한 글자 이상 입력해야합니다.")),
                fieldWithPath("maker").type(STRING).description("상품 제조사")
                        .attributes(key("constraints").value("한 글자 이상 입력해야합니다.")),
                fieldWithPath("price").type(NUMBER).description("상품 가격")
                        .attributes(key("constraints").value("빈 값을 입력할 수 없습니다.")),
                fieldWithPath("imageUrl").type(STRING).description("상품 이미지").optional()
                        .attributes(key("constraints").value(""))
        );
    }

    public static ResponseFieldsSnippet getProductDataResponseFieldsSnippet() {
        return responseFields(
                fieldWithPath("id").type(NUMBER).description("상품 식별자"),
                fieldWithPath("name").type(STRING).description("상품 이름"),
                fieldWithPath("maker").type(STRING).description("상품 제조사"),
                fieldWithPath("price").type(NUMBER).description("상품 가격"),
                fieldWithPath("imageUrl").type(STRING).optional().description("상품 이미지 URL")
        );
    }

    public static ResponseFieldsSnippet getProductListDataResponseFieldsSnippet() {
        return responseFields(
                fieldWithPath("[].id").type(NUMBER).description("상품 식별자"),
                fieldWithPath("[].name").type(STRING).description("상품 이름"),
                fieldWithPath("[].maker").type(STRING).description("상품 제조사"),
                fieldWithPath("[].price").type(NUMBER).description("상품 가격"),
                fieldWithPath("[].imageUrl").type(STRING).optional().description("상품 이미지 URL")
        );
    }
}
