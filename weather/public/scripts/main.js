const url = "http://localhost:3001/api/forecast/";
let $notifier = $("#notifier")

$("#btn-forecast").click(()=>{
    let town = $('#input-town').val();

    if (town.length < 1) {
        $notifier.html("Please choice a town!");

        setTimeout(()=>{
        $notifier.html("");
        }, 5000);

        return;
    }

    let $forecastConteiner = $('#forecast-conteiner')

    $.ajax({
        url:url+town
    }).then(response => {
        $forecastConteiner.html(response);
    })
})



