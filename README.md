EasyJson is a Gson wrapper that simplifies the navigation of JSON documents that have not been mapped to POJOs.

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

We want to access the author's first name. 
First, we parse the JSON document using  GSon:

    String json = "...";
    JsonElement jsonElt = new JsonParser().parse(json);
    
Gson:

    String firstName = jsonElt.getAsJsonObject().get("book").getAsJsonObject().get("author").getAsJsonObject().get("first_name").getAsString();
        
EasyJson:

    EasyJson ej = EasyJson.parse(json);
    ej.getString("book.author.first_name")   // = Rick
    
## Iterate

TODO