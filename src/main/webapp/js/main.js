$(function() {
    function toggleClasses() {
        $(".archive-checkbox").toggleClass("noshow");
        $(".news-link").toggleClass("noshow");
        $(".news-archive-buttons").toggleClass("noshow");
    }

    $(".news-link").click(function() {
        toggleClasses();
        $(this).parent().children("input.archive-checkbox").prop("checked", true);
    });

    $("a.cancel-saving").click(function() {
        toggleClasses();
        $("input.archive-checkbox").prop("checked", false);
    });

    $("a.save-selected").click(function() {
        $("#news-form").submit();
    });

    $("a.header-link").click(function(event) {
        event.preventDefault();
        window.history.pushState("object or string", "Title", $(this).attr('href'));
    });

});