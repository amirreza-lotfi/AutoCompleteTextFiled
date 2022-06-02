package com.amirreza.autocompletetextfield

import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun AutoCompleteTextFiled(
    textFiledValue: MutableState<String>,
    itemComposable: @Composable (item:String) -> Unit,
    autoCompleteAdapter: AutoCompleteAdapter,
    columnContainerModifier: Modifier = Modifier,
    contentPaddingOfContainerColumn: PaddingValues = PaddingValues(0.dp),
    reverseLayoutOfContainerColumn: Boolean = false,
    verticalArrangementOfContainerColumn: Arrangement.Vertical = if (!reverseLayoutOfContainerColumn) Arrangement.Top else Arrangement.Bottom,
    horizontalAlignmentOfContainerColumn: Alignment.Horizontal = Alignment.Start,
    flingBehaviorOfContainerColumn: FlingBehavior = ScrollableDefaults.flingBehavior(),
) {
    autoCompleteAdapter.onTextFiledChanged(textFiledValue.value)
    LazyColumn(
        modifier = columnContainerModifier,
        contentPadding = contentPaddingOfContainerColumn,
        flingBehavior = flingBehaviorOfContainerColumn,
        horizontalAlignment = horizontalAlignmentOfContainerColumn,
        verticalArrangement = verticalArrangementOfContainerColumn,
        reverseLayout = reverseLayoutOfContainerColumn
    ){
        items(autoCompleteAdapter.getList()){ item ->
            itemComposable(item)
        }
    }
}

@Composable
fun AutoCompleteTextFiled(
    textFiledValue:MutableState<String>,
    itemComposable: @Composable (item:String) -> Unit,
    itemList: List<String>,
    columnContainerModifier: Modifier = Modifier,
    contentPaddingOfContainerColumn: PaddingValues = PaddingValues(0.dp),
    reverseLayoutOfContainerColumn: Boolean = false,
    verticalArrangementOfContainerColumn: Arrangement.Vertical = if (!reverseLayoutOfContainerColumn) Arrangement.Top else Arrangement.Bottom,
    horizontalAlignmentOfContainerColumn: Alignment.Horizontal = Alignment.Start,
    flingBehaviorOfContainerColumn: FlingBehavior = ScrollableDefaults.flingBehavior(),
) {
    val autoCompleteAdapter = remember {
        AutoCompleteAdapter(itemList)
    }

    autoCompleteAdapter.onTextFiledChanged(textFiledValue.value)
    LazyColumn(
        modifier = columnContainerModifier,
        contentPadding = contentPaddingOfContainerColumn,
        flingBehavior = flingBehaviorOfContainerColumn,
        horizontalAlignment = horizontalAlignmentOfContainerColumn,
        verticalArrangement = verticalArrangementOfContainerColumn,
        reverseLayout = reverseLayoutOfContainerColumn
    ){
        items(autoCompleteAdapter.getList()){ item ->
            itemComposable(item)
        }
    }
}
