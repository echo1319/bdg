<script>

    var fetchData = function () {
        $.getJSON('metrics/garden/aqi', function (data) {
            console.log("data are" + data);
            return data.value;
        });
    }

    var config = {
        type: 'doughnut',
        data: {
            labels: ["ERPI", "AQI"],
            datasets: [{
                data: [
                    48,
                    2
                ],
                backgroundColor: [
                    "#F7464A",
                    "#FFFFFF"
                ],
                labels: ['ERPI']
            },
                {
                    data: [
                        50,
                        2
                    ],
                    backgroundColor: [
                        "#46BFBD",
                        "#FFFFFF"
                    ],
                    labels: ['AQI']
                }],
        },
        options: {
            responsive: true,
            legend: {
                display: false,
            },
            tooltips: {
                callbacks: {
                    label: function (tooltipItem, data) {
                        var dataset = data.datasets[tooltipItem.datasetIndex];
                        var index = tooltipItem.index;
                        return dataset.labels[index] + ': ' + dataset.data[index];
                    }
                }
            }

        }
    };

    var ctx2 = document.getElementById("erpiCity");
    var erpiCity = new Chart(ctx2, config);

</script>