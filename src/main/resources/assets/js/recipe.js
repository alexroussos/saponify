$(document).ready(function () {
 // TODO get url for current recipe
    $.getJSON("/recipe/1", listIngredients);

	$(".tooltip-info").popover();

	$(".tooltip-info").bind({
		mouseenter : showTooltip,
		mouseleave: hideTooltip
	});
});

var listIngredients = function(data) {
    var items = [];
    $(data.ingredientAmount).each(function() {
        items.push( "<li>Ingredient " + this.ingredientId + ": " + this.amountGrams + " g</li>" );
    });

    $( "<ul/>", {
    "class": "my-new-list",
    html: items.join( "" )
    }).appendTo( "body" );
}

var showTooltip = function(e){
	$(e.target).popover('show');
}

var hideTooltip = function(e){
	$(e.target).popover('hide');
}