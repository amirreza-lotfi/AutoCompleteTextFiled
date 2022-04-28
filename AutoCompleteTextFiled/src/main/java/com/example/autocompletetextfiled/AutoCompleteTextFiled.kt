package com.example.autocompletetextfield

import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AutoCompleteTextFiled(
    textFiledValue:MutableState<String>,
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
