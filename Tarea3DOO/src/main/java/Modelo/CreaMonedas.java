package Modelo;

public enum CreaMonedas {
    MONEDA100(){
        @Override
        public Moneda crearMoneda(int serie){return new Moneda100(serie);}
    },
    MONEDA500(){
        @Override
        public Moneda crearMoneda(int serie){return new Moneda500(serie);}
    } ,
    MONEDA1000(){
        @Override
        public Moneda crearMoneda(int serie){return new Moneda1000(serie);}
    },
    MONEDA1500(){
        @Override
        public Moneda crearMoneda(int serie){return new Moneda1500(serie);}
    };

    public abstract Moneda crearMoneda(int serie) ;
}
