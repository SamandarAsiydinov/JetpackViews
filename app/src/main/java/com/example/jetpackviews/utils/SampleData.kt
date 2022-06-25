package com.example.jetpackviews.utils

import com.example.jetpackviews.R
import com.example.jetpackviews.shopping.model.Product

val myProduct = Product(
    "Shopping",
    "\$199",
    "Lorem Ipsum is simply dummy text of " +
            "the printing and typesetting industry. " +
            "Lorem Ipsum has been the industry's standard dummy text ever since. " +
            "When an unknown printer took a galley.",
    "42 M",
    R.drawable.img_sneak
)

object SampleData {
    val set1 = """
                {
                  bgCard: {
                    bottom: ['parent', 'bottom']
                  },
                  productImage: {
                    top: ['bgCard', 'top'],
                    bottom: ['bgCard', 'top'],
                    right: ['bgCard', 'right']
                  },
                  productCategory: {
                    top: ['parent', 'top'],
                    left: ['parent', 'left']
                  },
                  productTitle: {
                    top: ['productCategory', 'bottom'],
                    left: ['parent', 'left']
                  },
                  productPrice: {
                    bottom: ['bgCard', 'top'],
                    left: ['parent', 'left']
                  },
                  productPriceLabel: {
                    bottom: ['productPrice', 'top'],
                    left: ['parent', 'left']
                  }
                }
            """.trimIndent()

    val set2 = """
                        {
                          txtColor: {
                            top: ['parent', 'top'],
                            left: ['parent', 'left']
                          },
                          txtSize: {
                            top: ['txtColor', 'top'],
                            left: ['txtColor', 'right']
                          },
                          txtSizeValue: {
                            top: ['txtSize', 'bottom'],
                            left: ['txtSize', 'left']
                          },
                          txtDescription: {
                            top: ['txtSizeValue', 'bottom'],
                            left: ['parent', 'left'],
                            right: ['parent', 'right']
                          },
                          btnMinus: {
                            top: ['txtDescription', 'bottom'],
                            left: ['parent', 'left']
                          },
                          txtQtd: {
                            top: ['btnMinus', 'top'],
                            bottom: ['btnMinus', 'bottom'],
                            left: ['btnMinus', 'right']
                          },
                          btnPlus: {
                            top: ['txtDescription', 'bottom'],
                            left: ['txtQtd', 'right']
                          },
                          btnHeart: {
                            top: ['btnPlus', 'top'],
                            bottom: ['btnPlus', 'bottom'],
                            right: ['parent', 'right']
                          },
                          btnAddtoCart: {
                            top: ['btnMinus', 'bottom'],
                            left: ['parent', 'left']
                          },
                          btnBuy: {
                            top: ['btnMinus', 'bottom'],
                            left: ['btnAddtoCart', 'right'],
                            right: ['parent', 'right']
                          },
                          color1: {
                            top: ['txtColor', 'bottom'],
                            left: ['parent', 'left']
                          },
                          color2: {
                            top: ['txtColor', 'bottom'],
                            left: ['color1', 'right']
                          },
                          color3: {
                            top: ['txtColor', 'bottom'],
                            left: ['color2', 'right']
                          }
                        }
                    """.trimIndent()
}

object MotionObject {
    val set1 = """
                    {
                      a: {
                        width: 40,
                        height: 40,
                        start: ['parent', 'start', 16],
                        bottom: ['parent', 'bottom', 16]
                      },
                      b: {
                        width: 40,
                        height: 40,
                        bottom: ['a', 'top', 16],
                        start: ['a', 'end', 16]
                      }
                    }
                """.trimIndent()

    val set2 = """ 
                    {
                      a: {
                        width: 40,
                        height: 40,
                        visibility: 'gone',
                        end: ['parent', 'end', 100],
                        top: ['parent', 'top', 100]
                      },
                      b: {
                        width: 40,
                        height: 40,
                        top: ['a', 'bottom', 16, 20],
                        end: ['a', 'start', 16, 20]
                      }
                    }
                """.trimIndent()
}