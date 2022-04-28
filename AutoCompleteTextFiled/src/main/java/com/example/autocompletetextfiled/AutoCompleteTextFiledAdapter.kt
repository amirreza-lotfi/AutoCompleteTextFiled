package com.example.autocompletetextfield

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable

open class AutoCompleteAdapter(inputList: List<String>) {

    private var mainDataList = inputList
    private var dataList = mainDataList
    var textFiledValue:String ? = null


    fun getList():List<String>{
        return dataList
    }

    open fun filter(
        dataListValue:String,
        textFiledValue:String,
        condition:()->Boolean = {
            dataListValue.startsWith(textFiledValue)
        }
    ):Boolean{
        return condition()
    }

    fun onTextFiledChanged(currentValue:String){
        if(textFiledValue != null) {
            if (currentValue.length > textFiledValue!!.length) {
                onTextFieldLengthIncrease(currentValue)
            } else {
                onTextFieldLengthDecrease(currentValue)
            }
        }
        textFiledValue = currentValue
    }


    private fun onTextFieldLengthIncrease(textFiledValue: String){
        val mutableList = mutableListOf<String>()
        for(item in dataList){
            if(
                filter(item, textFiledValue)
            ){
                mutableList.add(item)
            }
        }
        dataList = mutableList
    }
    private fun onTextFieldLengthDecrease(textFiledValue: String){
        val mutableList = mutableListOf<String>()
        for(item in mainDataList){
            if(
                filter(item, textFiledValue)
            ){
                mutableList.add(item)
            }
        }
        dataList = mutableList
    }


}

@Composable
fun rememberAutoCompleteAdapter(autoCompleteAdapter: AutoCompleteAdapter): AutoCompleteAdapter {
    val adapter = remember(){
        autoCompleteAdapter
    }
    return adapter
}