$(function() {
    function toggleNewsClasses() {
        $(".header").toggleClass("noshow");
        $(".archive-checkbox").toggleClass("noshow");
        $(".news-link").toggleClass("noshow");
        $(".menu-buttons").toggleClass("noshow");
    }

    $(document).on("click", "a.news-link", function(){
        toggleNewsClasses();
        $(this).parent().children("input.archive-checkbox").prop("checked", true);
    });

    $(document).on("click", "a.menu-link.news.cancel", function(){
        toggleNewsClasses();
        $("input.archive-checkbox").prop("checked", false);
    });

    function toggleArchiveClasses() {
        $(".header").toggleClass("noshow");
        $(".remove-checkbox").toggleClass("noshow");
        $(".archive-link").toggleClass("noshow");
        $(".menu-buttons").toggleClass("noshow");
    }

    $(document).on("click", "a.archive-link", function(){
        toggleArchiveClasses();
        $(this).parent().children("input.remove-checkbox").prop("checked", true);
    });

    $(document).on("click", "a.menu-link.archive.cancel", function(){
        toggleArchiveClasses();
        $("input.remove-checkbox").prop("checked", false);
    });

    $(document).on("click", "a.menu-link.action", function(){
        event.preventDefault();
        var formData = "";

        $(":checked").each(function() {
            formData += $(this).val() + "&"
        });

        $.post("/content" + window.location.pathname, formData, function(data) {
            $("#content").html(data);
        });
    });

    $(document).ready(function() {
        $.get("/content" + window.location.pathname, function(data) {
            $("#content").html(data);
        });
    });

    $("#content").load("loading.html");

    $(document).on("click", "a.header-link", function(event) {
        event.preventDefault();
        window.history.pushState("object or string", "Title", $(this).attr('href'));
        $("#content").load("loading.html");
        $.get("/content" + $(this).attr('href'), function(data) {
            $("#content").html(data);
        });
    });

    $(document).on("submit", "#signup-form", function(event) {
        event.preventDefault();

        var formData = {
            'username': $('input[name=username]').val(),
            'email': $('input[name=email]').val(),
            'password': $('input[name=password]').val()
        };

        $.post("/content/signup", formData, function(data) {
            $("#content").html(data);
        });
    });

    $(document).on("submit", "#login-form", function(event) {
        event.preventDefault();

        var formData = {
            'username': $('input[name=username]').val(),
            'password': $('input[name=password]').val()
        };

        $.post("/content/login", formData, function(data) {
            $("#content").html(data);
        });
    });

    $(document).ready(function() {
        var audioElement = document.createElement('audio');
        audioElement.setAttribute('src', 'http://cast.loungefm.com.ua/terrace128');
        audioElement.setAttribute('autoplay', 'autoplay');
        $.get();
        audioElement.addEventListener("load", function () {
            audioElement.play();
        }, true);
        audioElement.addEventListener('ended', function() {
            this.currentTime = 0;
            this.play();
        }, false);

        $("#music-mode").click(function() {
            $(this).toggleClass("play");
            $(this).toggleClass("pause");
            if($(this).hasClass("play")) {
                audioElement.pause();
            }
            else {
                audioElement.play();
            }
        });
    });

});