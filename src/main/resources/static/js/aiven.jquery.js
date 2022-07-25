$(document).ready(function(){
    $("button").click(function(){
        $(".show").removeClass("show").addClass("hide");
        $("."+this.id).removeClass("hide").addClass("show");
    });
});