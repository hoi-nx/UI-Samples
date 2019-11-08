package com.iiinaiii.uisamples.ui.home

import com.iiinaiii.uisamples.R

interface HomeListType {
    val titleId: Int
}

enum class ParentHomeListType(vararg val children: ChildHomeListType) : HomeListType {
    // Extended Fab
    EXTENDED_FAB() {
        override val titleId: Int = R.string.title_extended_fab
    },
    // Motion Layout
    MOTION_LAYOUT(
        ChildHomeListType.MOTION_LAYOUT_SIMPLE_01,
        ChildHomeListType.MOTION_LAYOUT_YOUTUBE
    ) {
        override val titleId: Int = R.string.title_motion_layout
    };

    fun hasChild(): Boolean = children.isNotEmpty()

}

enum class ChildHomeListType : HomeListType {
    MOTION_LAYOUT_YOUTUBE {
        override val titleId: Int = R.string.title_youtube_style
    },
    MOTION_LAYOUT_SIMPLE_01 {
        override val titleId: Int = R.string.title_simple_01
    }
}
