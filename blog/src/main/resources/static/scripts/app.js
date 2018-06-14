$(document).ready(function() {

    $('#search_text').keypress(function(event){

        var keycode = (event.keyCode ? event.keyCode : event.which);
        if(keycode == '13'){
            var dInput = this.value;
            console.log('search word = ' +dInput);

            $.ajax({
                    type: "GET",
                    contentType: "application/json",
                    url:"/test",
                    dataType: "json",
                    success: function(data){
                        var options = {
                            keys: ['category', 'article.title']
                        };
                        var fuse = new Fuse(data, options);

                        var result = fuse.search(dInput+'');
                        $('#search_result').empty();
                        result.forEach(function(entry){
                            var category = entry['category'];
                            var article = entry['article'];
                            clone(category, article);
                        });
                    },
                    error: function (e){
                        console.log('ERROR: ', e);
                        display(e);
                    },
                    done: function (e){
                        console.log('DONE');
                    }
            });
                event.preventDefault();
        }
    });
});

function clone( category, article){
        var $a = $('a[id^="search_clone"]:last');
        var num = parseInt($a.prop("id").match(/\d+/g), 10)+1;

        var $klon = $a.clone().prop('id', 'search_clone'+num);
        $klon.prop('style', 'display: block');
        $klon.prop('href', '/article/' +article.id);
        $klon.find('h5').text(article.title);
        $klon.find('p').text(article.content);
        $klon.find('small').text('category:'+category);
        $('#search_result').append($klon);
}