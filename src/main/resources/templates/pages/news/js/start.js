$(document).ready(function(){
            $('#banners').bannerize({
                shuffle: 1,
                interval: "5"
            });
            $(".ui-line").hover(function(){
                $(this).addClass("ui-line-hover");
                $(this).find(".ui-bnnerp").addClass("ui-bnnerp-hover");
            },function(){
                $(this).removeClass("ui-line-hover");
                $(this).find(".ui-bnnerp").removeClass("ui-bnnerp-hover");
            });
        });