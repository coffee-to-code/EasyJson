EasyJson is a Gson wrapper that simplifies the navigation of JSON documents that have not been mapped to POJOs.

## Getting Started 

First, we must build a EasyJson instance from a JSON document.
If you already have a Gson JsonElement instance, we just invoke the constructor:

    EasyJson es = new EasyJson(jsonElement);    

Alternatively, we 

    EasyJson es = EasyJsonParser.parse("{ \"city\" : \"New York\" }");  // parse from String
    EasyJson es = EasyJsonParser.parse(new File(path));                 // parse from file
    EasyJson es = EasyJsonParser.parse(reader);                         // parse from Reader

The EasyJson parser is just a wrapper around the Gson parser.

## Example 

For example, let's consider a JSON document like the following: 

    {
        "book": {
            "id": "978-0641723445",
            "cat": [
                "book",
                "hardcover"
            ],
            "name": "The Lightning Thief",
            "author": {
              "first_name":"Rick",
              "last_name":"Riordan"
            },
            "series_t":"Percy Jackson and the Olympians",
            "sequence_i": 1,
            "genre_s": "fantasy",
            "inStock": true,
            "price": 12.50,
            "pages_i": 384
        }
    }

We want to get the author's first name. Let's compare EasyJson with Gson.
Here we assume that the above document has been loaded into a `json` variable of type String.

__Gson:__

    JsonElement jsonElt = new JsonParser().parse(json);  
    String firstName = jsonElt.getAsJsonObject().get("book").getAsJsonObject().get("author").getAsJsonObject().get("first_name").getAsString(); // = Rick
        
__EasyJson:__

    EasyJson ej = EasyJson.parse(json);
    String firstName = ej.getString("book.author.first_name");   // = Rick

As you see, the EasyJson approach is not just shorter, but makes the source code much more readable.

For each primitive type there is a correspondend `get...` method, for example:

    ej.getBoolean("book.inStock");      // => true
    ej.getFloat("book.price");          // => 12.50
    ej.getInteger("book.pages_i");      // => 384

For each get_Type_() method, you can supply an optional default value to be returned in case the property is null or missing:

    ej.getInteger("book.pages_i", 100);

## Iterate

Let's start with a simple JSON array:

    [
        "Jon", "Ritchie", "Ian"
    ]

We can iterate over the array using a lambda expression:
  
    EasyJson easyJson = EasyJsonParser.parse(json);

    easyJson.iterate(ej -> {
        String name = ej.getString();
        // ...        
    });

In this example we have an array nested in an object:  

    {
        "book": {
            "id": "978-0641723445",
            "cat": [
                "book",
                "hardcover"
            ]            
        }
    }

In this case, we pass the array path as first argument of the `iterate()` method:

    easyJson.iterate("book.cat", ej -> {
        String name = ej.getString();
        // ...        
    });

Another example: a nested array of objects:

    {
        "menu": {
            "id": "file",
            "value": "File",
            "popup": {
                "level" : "default",
                "menuitem": [
                    {
                        "value": "New",
                        "onclick": "CreateNewDoc()"
                    },
                    {
                        "value": "Open",
                        "onclick": "OpenDoc()"
                    },
                    {
                        "value": "Close",
                        "onclick": "CloseDoc()"
                    }
                ]
            }
        }
    }

We can retrieve the `value` property of each `menuitem` object: 

    easyJson.iterate("menu.popup.menuitem", ej -> {
        String value = ej.getString("value");
    });

As seen above, the `iterate()` method accepts a lambda expression and, optionally, a path as first argument.
The corresponding method `iterateRaw()` behaves exactly like `iterate()`, but the argument of the lambda expression is
a Gson JsonElement instance:

    easyJson.iterateRaw("menu.popup.menuitem", jsonElement -> {
        String value = jsonElement.getAsJsonObject().get("value").getAsString();
    });

Alternatively, you can use the `iterate()` method and invoke `ej.getWrappedJsonElement()`.

## Accessing the native Gson object

Since EasyJson just wraps a Gson JsonElement instance, at any time we can access the wrapped object invoking:

    JsonElement elt = ej.getWrappedJsonElement(); 

and use it as a regular JsonElement instance. 

## Conclusions

There is nothing that you can do with EasyJson that cannot be done with Gson.
However, if your application is highly dynamic and mapping any type of JSON document to a POJO is not possible,
EasyJson can be helpful in keeping your code readable and clean.

## License

EasyJson is open-sourced software licensed under the [MIT license](http://opensource.org/licenses/MIT).
