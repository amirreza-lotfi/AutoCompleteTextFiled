# AutoCompleteTextFiled
This library is AutoCompleteTextFiled library in jetpack compose framework. 
The Composable only displays items from the list that begin with the value of TextFiled (by default. You can customize your filter function).
# Screenshots
<div>
  <img src="/screenshots/1.jpg" width="200" style="margin-right:100px"/>
  <img src="/screenshots/2.jpg" width="200"/>
  <img src="/screenshots/3.jpg" width="200"/>
  <img src="/screenshots/4.jpg" width="200"/>
 </div>
 
 # Getting Start <br/>


  __Step 1.__  Add it in your root build.gradle(project level) at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	
__Step 2.__ Add the dependency in build.gradle(module level)

	dependencies {
	        implementation 'com.github.amirreza-lotfi:AutoCompleteTextFiled:1.0.0'
	}
  
  # Use in project
  First, create your own TextField :
  
    var text = remember {
        mutableStateOf("")
    }
    
    Column {
        TextField(
            value = text.value,
            onValueChange = {text.value = it}
        )
    }
then define your list. for example:

    val listOfCity = listOf("Tehran","Baghdad", "Paris", "Ardabil", "Shiraz", "Oslo")

At the end, create call AutoCompleteTextFiled and pass value of TextFiled and your list:

    AutoCompleteTextFiled(
        textFiledValue = text,
        itemComposable = { item ->
             Box(
	     	Modifier.clickable { 
            	    textFiledValue.value = item
        	}
	     ){
                 Text(item)
             }            
        },
        itemList = listOfCity 
    )

AutoCompleteTextFiled is a lazyColumn and there is a modifier parameter that you can customize your list. also 
itemComposable is a Composable that each item of list placed in. <br/><br/>
AutoCompleteTextField has other overload that has AutoCompleteTextFiledAdapter. This adapter manage list.
so you can create your own class and inheritance from this class and override some function like filter.
