var basic = (function () {
    var numeros = [];
return{
    
    addData: function () {
        
        var num = document.getElementById("numero").value;
        if ( !isNaN(num) ){
            var nume = parseFloat(num);
            if ( !isNaN(nume) ){
                var fila = '<tr><td>' + num  + '</td></tr>';
                var tabla = document.getElementById("datos");
                tabla.innerHTML += fila;
                numeros.push(nume);
            }
            document.getElementById("numero").value = null;
        }        
    },

    showResults: function(valor){
        var lista = valor.split("-");
        var media = lista[0];
        var desviacion = lista[1];

        var outputMedia = document.getElementById("media");
        outputMedia.innerHTML = media;

        var outputMedia = document.getElementById("desviacion");
        outputMedia.innerHTML = desviacion;
    },

    getResults: function(){
        if(numeros.length>0){
            console.log(numeros);
            apiclient.getMean(numeros,this.showResults);
        }
    }
    
};
})();