function ajaxHtml(diadiem, url)
{
    $.ajax({
        url: url,
        success: function(result) {
            $(diadiem).html(result);
        }
    });
}