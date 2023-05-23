package com.yumtaufikhidayat.pitjarusx.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import com.yumtaufikhidayat.pitjarusx.R

class MaterialCustomEditText : AppCompatEditText, View.OnTouchListener {

    private lateinit var personIcon: Drawable
    private lateinit var passwordIcon: Drawable
    private lateinit var clearIcon: Drawable


    constructor(context: Context): super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet): super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        personIcon = ContextCompat.getDrawable(context, R.drawable.ic_outline_person) as Drawable
        passwordIcon = ContextCompat.getDrawable(context, R.drawable.ic_outline_key) as Drawable
        clearIcon = ContextCompat.getDrawable(context, R.drawable.ic_outline_clear) as Drawable

        setOnTouchListener(this)

        when (id) {
            R.id.etUsername -> {
                addTextChangedListener(object: TextWatcher {
                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                        if (p0.toString().isNotEmpty()) showClearButton() else hideClearButton()
                    }

                    override fun afterTextChanged(p0: Editable?) {
                        if (p0.toString().trim().isEmpty()) {
                            this@MaterialCustomEditText.error = "Masukkan username"
                        }
                    }
                })
            }

            R.id.etPassword -> {
                addTextChangedListener(object : TextWatcher {
                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                        if (p0.toString().isNotEmpty()) showClearButton() else hideClearButton()
                    }

                    override fun afterTextChanged(p0: Editable?) {
                        if (this@MaterialCustomEditText.text?.trim().toString().isEmpty()) {
                            this@MaterialCustomEditText.error = "Masukkan password"
                        }
                    }
                })
            }
        }
    }

    private fun showClearButton() {
        when (id) {
            R.id.etUsername -> {
                setButtonDrawables(
                    startOfTheText = personIcon,
                    endOfTheText = clearIcon
                )
            }

            R.id.etPassword -> {
                setButtonDrawables(
                    startOfTheText = passwordIcon,
                    endOfTheText = clearIcon
                )
            }
        }
    }

    private fun hideClearButton() {
        when (id) {
            R.id.etUsername -> {
                setButtonDrawables(
                    startOfTheText = personIcon
                )
            }

            R.id.etPassword -> {
                setButtonDrawables(
                    startOfTheText = passwordIcon
                )
            }
        }
    }

    private fun setButtonDrawables(
        startOfTheText: Drawable? = null,
        topOfTheText: Drawable? = null,
        endOfTheText: Drawable? = null,
        bottomOfTheText: Drawable? = null
    ) {
        setCompoundDrawablesWithIntrinsicBounds(
            startOfTheText,
            topOfTheText,
            endOfTheText,
            bottomOfTheText
        )
    }

    override fun onTouch(view: View, event: MotionEvent): Boolean {
        when (view.id) {
            R.id.etUsername -> {
                if (compoundDrawables[2] != null) {
                    val clearButtonStart: Float
                    val clearButtonEnd: Float
                    var isClearButtonClicked = false
                    if (layoutDirection == View.LAYOUT_DIRECTION_RTL) {
                        clearButtonEnd = (clearIcon.intrinsicWidth + paddingStart).toFloat()
                        when {
                            event.x < clearButtonEnd -> isClearButtonClicked = true
                        }
                    } else {
                        clearButtonStart = (width - paddingEnd - clearIcon.intrinsicWidth).toFloat()
                        when {
                            event.x > clearButtonStart -> isClearButtonClicked = true
                        }
                    }

                    if (isClearButtonClicked) {
                        when (event.action) {
                            MotionEvent.ACTION_DOWN -> {
                                personIcon = ContextCompat.getDrawable(
                                    context,
                                    R.drawable.ic_outline_person
                                ) as Drawable
                                clearIcon = ContextCompat.getDrawable(
                                    context,
                                    R.drawable.ic_outline_clear
                                ) as Drawable
                                showClearButton()
                                return true
                            }

                            MotionEvent.ACTION_UP -> {
                                personIcon = ContextCompat.getDrawable(
                                    context,
                                    R.drawable.ic_outline_person
                                ) as Drawable
                                clearIcon = ContextCompat.getDrawable(
                                    context,
                                    R.drawable.ic_outline_clear
                                ) as Drawable
                                when {
                                    text != null -> text?.clear()
                                }

                                hideClearButton()
                                return true
                            }

                            else -> return false
                        }
                    } else return false
                }
            }

            R.id.etPassword -> {
                if (compoundDrawables[2] != null) {
                    val clearButtonStart: Float
                    val clearButtonEnd: Float
                    var isClearButtonClicked = false
                    if (layoutDirection == View.LAYOUT_DIRECTION_RTL) {
                        clearButtonEnd = (clearIcon.intrinsicWidth + paddingStart).toFloat()
                        when {
                            event.x < clearButtonEnd -> isClearButtonClicked = true
                        }
                    } else {
                        clearButtonStart = (width - paddingEnd - clearIcon.intrinsicWidth).toFloat()
                        when {
                            event.x > clearButtonStart -> isClearButtonClicked = true
                        }
                    }

                    if (isClearButtonClicked) {
                        when (event.action) {
                            MotionEvent.ACTION_DOWN -> {
                                passwordIcon = ContextCompat.getDrawable(
                                    context,
                                    R.drawable.ic_outline_key
                                ) as Drawable
                                clearIcon = ContextCompat.getDrawable(
                                    context,
                                    R.drawable.ic_outline_clear
                                ) as Drawable
                                showClearButton()
                                return true
                            }

                            MotionEvent.ACTION_UP -> {
                                passwordIcon = ContextCompat.getDrawable(
                                    context,
                                    R.drawable.ic_outline_key
                                ) as Drawable
                                clearIcon = ContextCompat.getDrawable(
                                    context,
                                    R.drawable.ic_outline_clear
                                ) as Drawable
                                when {
                                    text != null -> text?.clear()
                                }

                                hideClearButton()
                                return true
                            }

                            else -> return false
                        }
                    } else return false
                }
            }

            else -> return false
        }
        return false
    }
}