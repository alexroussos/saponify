$(document).ready(function () {
    $("#createRecipe").submit(function( event ) {

      // Stop form from submitting normally
      event.preventDefault();

      // Get some values from elements on the page:
      var $form = $( this ),
        recipeName = $form.find( "input[name='RecipeName']" ).val(),
        url = $form.attr( "action" );

      // Send the data using post
      // var request = $.post( url, { name: recipeName } );
      var postData = JSON.stringify({ name: recipeName });
      var request = $.ajax({url:url, type:"POST", data:postData,
              contentType:"application/json; charset=utf-8",
              dataType:"json"
            })

      // Put the results in a div
      request.done(function( data ) {
        $( "#result" ).empty().append( "<section>Created " + data.name + "</section>" );
      });
      request.fail(function( jqXHR, textStatus ) {
        $( "#result" ).empty().append( "<section>Failed: " + jqXHR.responseJSON.message + "</section>" );
      });
    });

});

