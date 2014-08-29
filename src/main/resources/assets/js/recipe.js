$(document).ready(function () {
    $("#createRecipe").submit(function( event ) {

      // Stop form from submitting normally
      event.preventDefault();

      // Get some values from elements on the page:
      var $form = $( this ),
        recipeName = $form.find( "input[name='RecipeName']" ).val(),
        url = $form.attr( "action" );

      // Send the data using post
      var postData = JSON.stringify({ name: recipeName });
      var request = $.ajax({url:url, type:"POST", data:postData,
              contentType:"application/json; charset=utf-8",
              dataType:"json"
            });

      // Put the results in a div
      request.done(function( data ) {
        $( "#result" ).empty().append( "<section>Created " + data.name + "</section>" );
      });
      request.fail(function( jqXHR, textStatus ) {
        $( "#result" ).empty().append( "<section>Failed: " + jqXHR.responseJSON.message + "</section>" );
      });
    });
});

var addIngredient = function(ingredient) {
    event.preventDefault();
    var ingredientId = ingredient.getAttribute("data-ingredient-id");
    var recipeId = $("body").data("recipe-id");
    var json = {"recipeId":recipeId, "ingredientId":ingredientId, "amountGrams": 17};
    var postData = JSON.stringify(json);
    var url = "/recipe/" + recipeId + "/addIngredient";
    var request = $.ajax({url:url, type:"POST", data:postData,
          contentType:"application/json; charset=utf-8",
          dataType:"json"
    });

    request.done(function( data ) {
        // TODO refresh the recipe -- 'data' is the recipe
    });
    request.fail(function( jqXHR, textStatus ) {
        $( "#ingredient-picker-message" ).empty().append( "<section>Failed: " + jqXHR.responseJSON.message + "</section>" );
    });
}
