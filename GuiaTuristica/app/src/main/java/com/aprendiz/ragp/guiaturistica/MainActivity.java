package com.aprendiz.ragp.guiaturistica;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.aprendiz.ragp.guiaturistica.fragments.FragmentRS;
import com.aprendiz.ragp.guiaturistica.models.GestorDB;
import com.aprendiz.ragp.guiaturistica.models.Sitios;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    public static int orien;
    public static int cargaR=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        inputDataM();

         orien= getWindowManager().getDefaultDisplay().getRotation();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = new Fragment();

        if (id == R.id.nav_camera) {

            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            cargaR=1;
            fragment= new FragmentRS();
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedorP,fragment).commit();
        } else if (id == R.id.nav_slideshow) {
            cargaR=2;
            fragment= new FragmentRS();
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedorP,fragment).commit();
        } else if (id == R.id.nav_manage) {
            cargaR=3;
            fragment= new FragmentRS();
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedorP,fragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void inputDataM(){
        GestorDB gestorDB = new GestorDB(getApplicationContext());
        Sitios sitios;
        SQLiteDatabase db = gestorDB.getWritableDatabase();
        Cursor cursor= db.rawQuery("SELECT * FROM DATOS",null);
        if (cursor.moveToFirst()){

        }else {
            Toast.makeText(this, "Hola", Toast.LENGTH_SHORT).show();
            try {
                sitios = new Sitios(R.drawable.portal_del_quindio, "Centro Comercial Portal del Quindío.\n",
                        "El Centro Comercial Portal del Quindio, ubicado en el norte de Armenia, es el centro comercial, más grande e importante del Quindío.\n",
                        "Dirección: Av Bolivar # 19 Norte 46 Armenia\n", "\"El Centro Comercial Portal del Quindio, ubicado en el norte de Armenia, es el centro comercial, más grande e importante del Quindío. Cuenta con 100 locales donde se encuentran representadas las marcas comerciales nacionales e internacionales más importantes.\n" +
                        "En su mall de comidas rápidas encontrará reconocidos restaurantes como Frisby, hamburguesas El Corral y Presto entre otras.\n" +
                        "Todo esta oferta se complementa con una espectacular diverzona y cuatro (4) modernas salas de Cinecolombia.\"\n", 4.545695136892776f, (float) -75.67256734597161
                );
                gestorDB.inputdata(sitios);


                sitios = new Sitios(R.drawable.unicentro, "Unicentro - Armenia.\n",
                        "Unicentro Armenia inaugurado en Septiembre de 2.012,  ubicado en la  esquina de la Avenida Bolívar con la Calle 4B \n",
                        "Avenida Bolívar con Calle 4B\n", "\"Unicentro Armenia inaugurado en Septiembre de 2.012,  ubicado en la  esquina de la Avenida Bolívar con la Calle 4B donde antiguamente funcionó la fabrica de Bavaria, a pocos minutos del Centro de Armenia.El centro comercial cuenta con 40 mil metros cuadrados, 129 locales comerciales y 410 parqueaderos.\n" +
                        "Entre las marcas comerciales que ya confirmarón su presencia en Unicentro Armenia, se destacan: Almacenes Exito, Pepe Ganga, Recreatec, Arturo Calle, entre otros.\"\n"
                        , (float) 4.537481262607865, (float) -75.66655919777826
                );
                gestorDB.inputdata(sitios);

                sitios = new Sitios(R.drawable.calima1, "Calima Centro Comercial Armenia\n",
                        "Calima Armenia nace de la necesidad de la ciudad y la región de abrir nuevos espacios comerciales para atender un mercado creciente\n",
                        "Avenida Centenario # 3 - 180. Armenia\n", "Calima Armenia nace de la necesidad de la ciudad" +
                        " y la región de abrir nuevos espacios comerciales para atender un mercado creciente. Un proyecto con sentido ambiental, hace énfasis en su diseño bioclimático de arquitectura abierta que optimiza el uso de la energía. Calima, un verdadero modelo de sostenimiento, será desarrollado en amplios espacios para atender necesidades comerciales, de servicios," +
                        " entretenimiento y parqueo.\n", (float) 4.5268715367044985, (float) -75.68767354714349

                );
                gestorDB.inputdata(sitios);

                sitios = new Sitios(R.drawable.parque_cafe, "Parque del Café\n",
                        "El Parque del Café  brinda a sus visitantes diversión y entretenimiento a través de la cultura cafetera\n",
                        "Montenegro Quindio\n", "El Parque del Café  brinda a sus visitantes diversión y entretenimiento a través de la cultura cafetera, dando a conocer la importancia del café y del gremio cafetero en el desarrollo económico del país, en un ambiente de naturaleza, con innovadoras, confiables y seguras atracciones  culturales y mecánicas, comprometidos con la conservación del medio ambiente, el bienestar de nuestros empleados y el de la comunidad.\n"
                        , (float) 4.569482343671689, (float) -75.74745929865719

                );
                gestorDB.inputdata(sitios);

                sitios = new Sitios(R.drawable.panaca, "Panaca\n",
                        "Somos el primer parque temático agropecuario en el mundo y el más grande en Latinoamérica\n",
                        "Kilometro 7, Vía Vereda Kerman Quimbaya, Quindío.\n", "Somos el primer parque temático agropecuario en el mundo y el más grande en Latinoamérica, te ofrecemos una experiencia única llena de diversión e interacción con el campo, en la que podrás encontrar los Shows más sorprendentes, las más impresionantes Estaciones temáticas y la colección de zoología doméstica más grande del mundo, donde vivirás una experiencia inigualable entre los animales, la naturaleza y el hombre.\n"
                        , (float) 4.622357223916545
                        , (float) -75.76650045717768


                );
                gestorDB.inputdata(sitios);

                sitios = new Sitios(R.drawable.salento, "Salento\n",
                        "Salento es un municipio colombiano en el departamento del Quindío.\n",
                        "Municipio en Colombia\n", "Salento es un municipio colombiano en el departamento del Quindío. Llamado el padre del Quindío por ser el municipio más antiguo de este departamento, es conocido como el municipio Cuna del árbol Nacional \"La Palma de Cera\", posee una gran variedad de atractivos turísticos entre ellos el Valle de Cocora en donde se puede encontrar un paisaje lleno de naturaleza, como el Barranquero o Momotus momota un ave comúnmente divisada, hacer caminatas ecológicas y disfrutar de los hermosos paisajes de esta localidad. \n"
                        , (float) 4.621929466163072
                        , (float) -75.76083563173823

                );
                gestorDB.inputdata(sitios);


                sitios = new Sitios(R.drawable.penas_blancas, "Eco Parque Peñas Blancas\n",
                        "ofrece un recorrido lleno de aire, naturaleza y paisaje\n",
                        "Corregimiento la virginia en Calarcá\n", "\"EL ECOPARQUE PEÑAS BLANCAS ofrece un recorrido lleno de aire, naturaleza y paisaje, el cual nos transporta por los parajes más bellos de nuestra región, entre un bosque lleno de verde que parece infinito al contemplar la hoya del Quindío e inalcanzable al observar\n" +
                        "la inmensa mole blanca y rocosa que sobresale en la montaña.\"\n"
                        , (float) 4.62470988694496
                        , (float) -75.7556428750854
                );
                gestorDB.inputdata(sitios);


                sitios = new Sitios(R.drawable.granja_mama_lulu, "La Pequeña Granja de Mamá Lulú\n",
                        "La Pequeña Granja de Mamá Lulú, es un paraíso ecológico \n",
                        "Quimbaya Quindio\n", "La Pequeña Granja de Mamá Lulú, es un paraíso ecológico que a través de años de estudio, esfuerzo y dedicación, ha permitido crear un ambiente en donde se integran el hombre y la naturaleza en armonía y cooperación. La propuesta que busca esta granja integral, es generar un cambio de actitud personal hacia la vida y la naturaleza, para no seguirla agrediendo, no seguir acabando con nuestros recursos y destruir todo a nuestro paso.\n"
                        , (float) 4.640840820686086
                        , (float) -75.56895314786989

                );
                gestorDB.inputdata(sitios);

                sitios = new Sitios(R.drawable.los_arrieros, "Parque Los Arrieros \n",
                        "EL Parque Los Arrieros es un lugar que ofrece servicios turísticos de recreación\n",
                        "Quimbaya Quindio\n", "EL Parque Los Arrieros es un lugar que ofrece servicios turísticos de recreación, esparcimiento y aprendizaje; en torno a la cultura de la arriería; a través de escenarios artísticos, culturales y áreas de entretenimiento que conforman un abanicó de opciones para que los visitantes, disfruten de una agradable experiencia en nuestras instalaciones.\n"
                        , (float) 4.531577482735009
                        , (float) -75.64214036690667

                );
                gestorDB.inputdata(sitios);



                sitios = new Sitios(R.drawable.bolivar_plaza, "Hotel Bolivar Plaza\n",
                        "Categoría del hotel:3,5 estrella(s), Cantidad de habitaciones: 18 \n",
                        "Dirección: Calle 21a No. 14-17, Armenia\n", "Hotel sencillo, sin mayores pretensiones pero bien ubicado, cerca del centro de armenia, con facilidad de acceso para visitantes de negocios. Adecuado para pasar una o dos noches, es acogedor y el servicio es muy bueno. Dirección Calle 21a No. 14-17, Armenia\n"
                        , (float) 4.45234778794663
                        , (float) -75.78196047823484

                );
                gestorDB.inputdata(sitios);


                sitios = new Sitios(R.drawable.mocawa, "Allure Aroma Mocawa Hotel\n",
                        "\" Categoría del hotel:3,5 estrella(s),\n" +
                                "Cantidad de habitaciones: 97 \"\n",
                        "Dirección: Carrera 14 No. 9N-00, Armenia\n", "Disfruta de un hotel de excelente calidad y con un sello personal que lo hace ser único. Con una atención cinco estrellas, lo hace una de las mejores alternativas en hospedaje es Armenia. Con una perfecta ubicación y contar con un buen restaurante y un centro comercial, Dirección Carrera 14 No. 9N-00, Armenia\n"
                        , (float) 4.447555758701706
                        , (float) -75.78938483278806

                );
                gestorDB.inputdata(sitios);


                sitios = new Sitios(R.drawable.armenia, "Armenia Hotel\n",
                        "\" Categoría del hotel:3 estrella(s),\n" +
                                "Cantidad de habitaciones: 129 \"\n" +
                                "Cantidad de habitaciones: 97 \"\n",
                        "Dirección: Avenida Bolivar 8\n", "Una excelente opción en Armenia, el hotel es amplio y muy bien atendido por todo el personal. Las habitaciones son bastante cómodas y muy bien dotadas par tener una agradable estadía. La estadía incluye un desayuno tipo bufete que está muy bien balanceado y ofrece gran variedad.  Dirección: Avenida Bolivar 8\n"
                        , (float) 4.624838213794354
                        , (float) -75.762595160852
                );
                gestorDB.inputdata(sitios);


                sitios = new Sitios(R.drawable.zuldemayda, "Hotel Zuldemayda\n",
                        "Hotel central, Cantidad de habitaciones: 27 \n",
                        "Dirección: Calle 20 15-38 Armenia\n", "Hotel ubicado en el centro de la cuidad de Armenia (dos cuadras del parque principal), confortable, elegante, la atención es espectacular, wifi muy rapido, desayuno incluido, precios especiales los fines de semana. En la recepción lo asesoran en planes de recreación en todo el eje cafetero. Dirección: Calle 20 15-38 Armenia\n"
                        , (float) 4.637932138866702
                        , (float) -75.57060538862306
                );
                gestorDB.inputdata(sitios);

                sitios = new Sitios(R.drawable.decameron, "Hotel Decameron Panaca\n",
                        "\" Categoría del hotel:3,5 estrella(s),\n" +
                                "Cantidad de habitaciones: 34 \"\n",
                        "Dirección: Km. 7 Vereda Kerman | Parque Nacional de la Cultura Agropecuaria, Quimbaya, Colombia \n", "Este hotel no solamente cuenta con una ambientación increíble sino además es parte de la naturaleza de Armenia. La atención es muy buena, la comida excelente y además entrada a panaca ilimitada, Dirección: Km. 7 Vereda Kerman | Parque Nacional de la Cultura Agropecuaria, Quimbaya, Colombia \n"
                        , (float) 4.622357223916545
                        , (float) -75.76650045717768

                );
                gestorDB.inputdata(sitios);

                sitios = new Sitios(R.drawable.heliconias, "Decameron Las Heliconias\n",
                        " Hotel campestre, Cantidad de habitaciones: 100 \n",
                        "Dirección: Km 2 Vía a Panaca, Vereda Kerman, Quimbaya \n", "Este excelente hotel, ubicado muy cerca de Panaca, como hotel, tienen una calificación de excelente, acceso al parque Panaca incluido y al Parque Nacional del Café, esto es muy bueno, además que cuenta con trasporte entre hoteles y parque, la comida buena, snack buenos, instalaciones excelentes, Dirección: Km 2 Vía a Panaca, Vereda Kerman, Quimbaya \n"
                        , (float) 4.621929466163072
                        , (float) -75.76083563173823

                );
                gestorDB.inputdata(sitios);

                sitios = new Sitios(R.drawable.arrayanes, "Hotel Arrayanes del Quindio\n",
                        "\" Categoría del hotel:3 estrella(s),\n" +
                                "Cantidad de habitaciones: 20 \"\n",
                        "Dirección: Km 1 Vía Montenegro-Parque del Cafe, Montenegro\n", "Lugar estupendo para una estancia tranquila, relajada, con un ambiente sobrio y además muy bien ubicado para desplazamientos hacia los sitios turísticos o parques temáticos. Además el desayuno es estupendo, y el sitio se presta para leer en un super ambiente, Dirección: Km 1 Vía Montenegro-Parque del Cafe, Montenegro\n"
                        , (float) 4.5659102936329115
                        , (float) -75.75595653681637

                );
                gestorDB.inputdata(sitios);


                sitios = new Sitios(R.drawable.la_esperanza, "Finca Hotel La Esperanza\n",
                        "Hotel campestre,  Cantidad de habitaciones: 39 \n",
                        "Dirección: Vereda la esperanza, Montenegro, Colombia \n", "Una gran estadía con familia en un lugar donde se respira naturaleza y está cerca de los atractivos turísticos de la región. Una experiencia de servicio magnífica donde cada uno de las personas que trabajan allí hacen todo por que la experiencia sea magnífica, Dirección: Vereda la esperanza, Montenegro, Colombia \n"
                        , (float) 4.566295305869581
                        , (float) -75.75057066111447

                );
                gestorDB.inputdata(sitios);

                sitios = new Sitios(R.drawable.el_roble, "El Roble\n",
                        "En el Restaurante El Roble encontrarás comida típica de la región con la mejor sazón\n",
                        "Dirección: Vía Armenia – Pereira\n", "En el Restaurante El Roble encontrarás comida típica de la región con la mejor sazón, y espacios para el esparcimiento familiar en nuestro Café Rockola y Parque Recreativo y Granja. El Roble es reconocido por su tradición gastronómica, sus amplios y verdes espacios para el entretenimiento familiar y su excelente ubicación, donde podrás vivir y sentir el paisaje cultural cafetero, apreciar el municipio de Salento y el nevado del Tolima. En el Restaurante El Roble encontrarás comida típica de la región con la mejor sazón, y espacios para el esparcimiento familiar en nuestro Café Rockola y Parque Recreativo y Granja.\n"
                        , (float) 4.545695136892776
                        , (float) -75.67256734597161


                );
                gestorDB.inputdata(sitios);

                sitios = new Sitios(R.drawable.la_fogata, "La Fogata\n",
                        "El Restaurante La Fogata ubicado en la ciudad de Armenia Colombia, es catalogado como el mejor restaurante del Triángulo del Café \n",
                        "ubicado en el norte de Armenia. Quindio.\n", "El Restaurante La Fogata ubicado en la ciudad de Armenia Colombia, es catalogado como el mejor restaurante del Triángulo del Café por diferentes medios especializados en gastronomía; El único sitio donde se destaca la constancia, la buena atención, el buen sabor y fidelidad de todos sus comensales. La Fogata está situada en el sector más dinámico de Armenia y por su ubicación se convierte en una bella isla urbana donde se disfrutan las más exquisitas sensaciones.\n"
                        , (float) 4.537481262607865
                        , (float) -75.66655919777826


                );
                gestorDB.inputdata(sitios);

                sitios = new Sitios(R.drawable.dar_papaya, "Dar Papaya",
                        "Este es uno de los restaurantes del Quindio más nuevos y exitosos.\n",
                        "Dirección: Av Centenario (Frente al CC Calima). Armenia, Quindío.\n", "\"\n" +
                        "Este es uno de los restaurantes del Quindio más nuevos y exitosos. Está localizado en la ciudad milagro de Colombia. Presenta a sus comensales una hermosa vista de las montañas de la Cordillera Central de Colombia y del cañón creado por la cuenca del Río Quindio y sus alrededores.\"\n"
                        , (float) 4.5268715367044985
                        , (float) -75.68767354714349


                );
                gestorDB.inputdata(sitios);

                sitios = new Sitios(R.drawable.casa_verde, "Casa Verde\n",
                        "Este es uno de los restaurantes del Quindio más nuevos y exitosos.\n",
                        "Dirección:  Vía Armenia – Cali.\n", "Casa Verde Campestre cuenta con un salón principal con capacidad para 200 personas, áreas ecológicas con plantas florales y frutales, parqueadero amplio, senderos naturales y zona de camping.\n"
                        , (float) 4.518144064907527
                        , (float) -75.71059034096673

                );
                gestorDB.inputdata(sitios);

                sitios = new Sitios(R.drawable.camelia_real, "Camelia Real\n",
                        "Restaurante de hotel campestre \n",
                        "Dirección: Vía Montenegro – Pueblo Tapao\n", "Ubicado al interior del Hotel Campestre las Camelias, tiene capacidad para 250 personas, ofrece una variedad de platos y comida Típica, Nacional e Internacional. \n"
                        , (float) 4.566295305869581
                        , (float) -75.75057066111447

                );
                gestorDB.inputdata(sitios);


                sitios = new Sitios(R.drawable.bosque_cocora, "Bosques de Cocora donde Juan B\n",
                        "El sitio está ubicado en pleno Valle del Cocora a 10 Km. del Municipio de Salento\n",
                        "Dirección: Valle de Cocora, Salento, Quindio\n", "El sitio está ubicado en pleno Valle del Cocora a 10 Km. del Municipio de Salento, es atendido directamente por sus propietarios lo que complementa la excelencia en el servicio, ya que consideramos que esto garantiza el calor humano que requiere este tipo de establecimientos. El Valle del Cocora es reconocido a nivel mundial y nacional por su hermoso paisaje, por sus palmas de Cera que miden más 60 metros (las más altas del mundo) y declaradas el árbol Nacional de Colombia. Allí es la cuna del nacimiento del Río Quindío y es una de las entradas al Parque Natural de los Nevados.\n"
                        , (float) 4.637932138866702
                        , (float) -75.57060538862306


                );
                gestorDB.inputdata(sitios);


                sitios = new Sitios(R.drawable.el_solar, "El Solar\n",
                        "Creado hace 10 años, inició como un juego empresarial con un salón con cocina y parrilla con capacidad para 80 personas.\n",
                        "Dirección: Vía Armenia – Pereira\n", "\"Creado hace 10 años, inició como un juego empresarial con un salón con cocina y parrilla con capacidad para 80 personas.\n" +
                        "\n" +
                        "El Restaurante El Solar abrió sus puertas a principios del año 2001, desde entonces ha crecido en su planta física y oferta gastronómica para brindarle a sus clientes una experiencia inolvidable. \"\n"
                        , (float) 4.640840820686086
                        , (float) -75.56895314786989


                );
                gestorDB.inputdata(sitios);


            } catch (Exception e) {

            }

            gestorDB.close();
        }
    }
}
