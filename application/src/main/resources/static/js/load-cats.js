function catToHtml(cat) {
    return "<li class=\"list-group-item\">" + cat.name + "</li>";
}

$( document ).ready(function() {
    $.ajax({
        url: "/api/cat",
    }).done(function(result) {
        var cats = "<ul class=\"list-group\">";
        var len = result.content.length;
        for (var i = 0; i < len; ++i) {
            cats = cats + catToHtml(result.content[i]) + "<br/>";
        }
        $("#result").html(cats + "</ul>");
    }).fail(function(result) {
        $("#result").html("<p>Could not load cats</p>");
    });
    console.log("1");
});
