<script>
    var color = "#0d912d";
    var quality = "Καλή";

    var humidex = 28;
    var max_humidex = 55;

    var config = {
        type: 'doughnut',
        data: {
            labels: ["Humidex"],
            datasets: [
                {
                    data: [
                        humidex,
                        max_humidex - humidex
                    ],
                    backgroundColor: [
                        color,
                        "#FFFFFF"
                    ],
                    labels: ['Humidex']
                }
            ],
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
                        return dataset.labels[index] + ': ' + humidex;
                    }
                }
            }

        }
    };


    var ctx = document.getElementById("humidexGarden");
    var humidexGarden = new Chart(ctx, config);

</script>

