$(function() {
    function toggleClasses() {
        $(".archive-checkbox").toggleClass("noshow");
        $(".news-link").toggleClass("noshow");
        $(".news-archive-buttons").toggleClass("noshow");
    }

    $("a.news-link").click(function() {
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

    $.get("/content/news", function(data) {
        $("#content").html(data);
    });

    $("a.header-link").click(function(event) {
        event.preventDefault();
        window.history.pushState("object or string", "Title", $(this).attr('href'));

        $.get("/content" + $(this).attr('href'), function(data) {
            $("#content").html(data);
        });
    });

    $(document).ready(function() {
        var audioElement = document.createElement('audio');
        audioElement.setAttribute('src', 'media/music.mp3');
        audioElement.setAttribute('autoplay', 'autoplay');
        $.get();
        audioElement.addEventListener("load", function () {
            audioElement.play();
        }, true);

        $('#play-music').click(function() {
            audioElement.play();
        });


        $('#pause-music').click(function() {
            audioElement.pause();
        });
    });

});