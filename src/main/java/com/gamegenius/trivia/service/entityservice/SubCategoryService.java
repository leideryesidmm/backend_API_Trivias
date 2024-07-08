package com.gamegenius.trivia.service.entityservice;

import com.gamegenius.trivia.mapper.SubCategoryInDtoToSubCategory;
import com.gamegenius.trivia.persistence.entity.Category;
import com.gamegenius.trivia.persistence.entity.SubCategory;
import com.gamegenius.trivia.persistence.repository.SubCategoryRepository;
import com.gamegenius.trivia.service.dto.CategoryInDto;
import com.gamegenius.trivia.service.dto.SubCategoryInDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubCategoryService {
    private final SubCategoryRepository repository;
    private final SubCategoryInDtoToSubCategory mapper;

    public SubCategoryService(SubCategoryRepository repository, SubCategoryInDtoToSubCategory mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public SubCategory createSubCategory(SubCategoryInDto subCategoryInDto){
        SubCategory subCategory = mapper.map(subCategoryInDto);
        subCategory=this.repository.save(subCategory);
        return subCategory;
    }
    public SubCategoryInDto getSubCategory(long id){
        System.out.println(id);
        SubCategory subCategory =this.repository.getById(id);
        SubCategoryInDto subCategoryInDto=this.mapper.map2(subCategory);
        return subCategoryInDto;
    }
    public List<SubCategoryInDto> getAllSubCategory(long id){
        try {
            System.out.println("entra");
            List<SubCategory> subCategorys = this.repository.findAllByCategory(id);
            System.out.println(subCategorys);
            List<SubCategoryInDto> subCategoryInDtos = new ArrayList<>();
            for (SubCategory subCategory : subCategorys) {
                SubCategoryInDto subCategoryInDto = this.mapper.map2(subCategory);
                subCategoryInDtos.add(subCategoryInDto);
            }
            System.out.println(subCategoryInDtos);
            return subCategoryInDtos;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public List<SubCategoryInDto> getAllSubCategorys(){
        try {
            System.out.println("entra");
            List<SubCategory> subCategorys = this.repository.findAll();
            System.out.println(subCategorys);
            List<SubCategoryInDto> subCategoryInDtos = new ArrayList<>();
            for (SubCategory subCategory : subCategorys) {
                SubCategoryInDto subCategoryInDto = this.mapper.map2(subCategory);
                subCategoryInDtos.add(subCategoryInDto);
            }
            System.out.println(subCategoryInDtos);
            return subCategoryInDtos;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public List<SubCategory> createTestDataSubCaregory(){
        try{
            SubCategoryInDto subCategoryInDto = new SubCategoryInDto();
            List<SubCategory> subCategories=new ArrayList<>();
            CategoryInDto category=new CategoryInDto();

            category.setIdCategory(2);
            subCategoryInDto.setCategory(category);
            subCategoryInDto.setName("Antigüedad");
            subCategoryInDto.setDescription("Explora las civilizaciones antiguas como Egipto, Mesopotamia, Grecia y Roma, y sus contribuciones a la historia temprana de la humanidad.");
            subCategories.add(createSubCategory(subCategoryInDto));

            subCategoryInDto.setName("Edad Media");
            subCategoryInDto.setDescription("Sumérgete en el período que abarca desde la caída del Imperio Romano hasta el Renacimiento, destacando eventos como las Cruzadas y el surgimiento de las monarquías europeas.");
            subCategories.add(createSubCategory(subCategoryInDto));

            subCategoryInDto.setName("Edad Moderna");
            subCategoryInDto.setDescription("Aprende sobre la era de los descubrimientos, la expansión colonial, las revoluciones políticas y científicas, y los cambios sociales que marcaron los siglos XVI al XVIII.");
            subCategories.add(createSubCategory(subCategoryInDto));

            subCategoryInDto.setName("Siglo XIX");
            subCategoryInDto.setDescription("Descubre los acontecimientos clave del siglo XIX, incluyendo las guerras napoleónicas, la Revolución Industrial, los movimientos nacionalistas y las primeras olas de globalización.");
            subCategories.add(createSubCategory(subCategoryInDto));

            subCategoryInDto.setName("Siglo XX");
            subCategoryInDto.setDescription("Explora los eventos que definieron el siglo XX, como las dos guerras mundiales, la Guerra Fría, los movimientos de derechos civiles, la descolonización y los avances tecnológicos.");
            subCategories.add(createSubCategory(subCategoryInDto));

            subCategoryInDto.setName("Siglo XXI");
            subCategoryInDto.setDescription("Conoce los desarrollos políticos, sociales y tecnológicos más relevantes desde el cambio de milenio hasta la actualidad, incluyendo temas como la globalización, el cambio climático y los avances en la comunicación digita");
            subCategories.add(createSubCategory(subCategoryInDto));


            category.setIdCategory(3);
            subCategoryInDto.setCategory(category);
            subCategoryInDto.setName("Cocinas del Mundo");
            subCategoryInDto.setDescription("Explora la diversidad culinaria global, descubriendo platos tradicionales y características únicas de diferentes regiones y países.");
            subCategories.add(createSubCategory(subCategoryInDto));

            subCategoryInDto.setName("Ingredientes y Especias");
            subCategoryInDto.setDescription("Conoce los componentes esenciales de la cocina, incluyendo hierbas, especias y otros ingredientes que aportan sabor y aroma a los platos.");
            subCategories.add(createSubCategory(subCategoryInDto));

            subCategoryInDto.setName("Técnicas de Cocina");
            subCategoryInDto.setDescription("Aprende sobre los métodos y procedimientos utilizados en la preparación de alimentos, desde técnicas básicas hasta avanzadas.");
            subCategories.add(createSubCategory(subCategoryInDto));

            subCategoryInDto.setName("Vinos y Bebidas");
            subCategoryInDto.setDescription("Sumérgete en el mundo de las bebidas, desde vinos y licores hasta cócteles y refrescos, conociendo su origen y características.");
            subCategories.add(createSubCategory(subCategoryInDto));

            subCategoryInDto.setName("Postres y Repostería");
            subCategoryInDto.setDescription("Descubre los dulces y postres más populares de diversas culturas, así como las técnicas para prepararlos y presentarlos.");
            subCategories.add(createSubCategory(subCategoryInDto));

            subCategoryInDto.setName("Chefs y Restaurantes Famosos");
            subCategoryInDto.setDescription("Conoce a los chefs más reconocidos a nivel mundial y los restaurantes que han dejado una marca en la historia de la gastronomía.");
            subCategories.add(createSubCategory(subCategoryInDto));

            category.setIdCategory(4);
            subCategoryInDto.setCategory(category);
            subCategoryInDto.setName("Cine Clásico");
            subCategoryInDto.setDescription("Explora las películas icónicas de la época dorada del cine, desde los años 20 hasta los 60, y descubre las obras maestras que sentaron las bases del cine moderno.");
            subCategories.add(createSubCategory(subCategoryInDto));

            subCategoryInDto.setName("Series de Televisión");
            subCategoryInDto.setDescription("Sumérgete en el mundo de las series, abarcando desde los clásicos de la televisión hasta las producciones más recientes y populares en plataformas de streaming.");
            subCategories.add(createSubCategory(subCategoryInDto));

            subCategoryInDto.setName("Directores y Productores");
            subCategoryInDto.setDescription("Conoce a los visionarios detrás de las cámaras, aquellos que han marcado la historia del cine y la televisión con su creatividad y estilo único.");
            subCategories.add(createSubCategory(subCategoryInDto));

            subCategoryInDto.setName("Géneros Cinematográficos");
            subCategoryInDto.setDescription("Descubre las características y ejemplos de diferentes géneros cinematográficos, desde el drama y la comedia hasta la ciencia ficción y el terror.");
            subCategories.add(createSubCategory(subCategoryInDto));

            subCategoryInDto.setName("Premios y Festivales");
            subCategoryInDto.setDescription("Aprende sobre los galardones más prestigiosos en el mundo del cine y la televisión, así como los festivales que celebran lo mejor de estas artes.");
            subCategories.add(createSubCategory(subCategoryInDto));

            subCategoryInDto.setName("Personajes y Actores Icónicos");
            subCategoryInDto.setDescription("Conoce a los personajes más memorables y a los actores y actrices que les dieron vida, dejando una huella indeleble en la pantalla grande y pequeña.");
            subCategories.add(createSubCategory(subCategoryInDto));


            category.setIdCategory(5);

            subCategoryInDto.setCategory(category);
            subCategoryInDto.setName("Géneros musicales");
            subCategoryInDto.setDescription("Explora los diferentes estilos y géneros musicales que han surgido a lo largo del tiempo, desde el rock hasta el jazz, pasando por el hip-hop, la música clásica y muchos más.");
            subCategories.add(createSubCategory(subCategoryInDto));

            subCategoryInDto.setName("Artistas y bandas famosas");
            subCategoryInDto.setDescription("Descubre la vida y obra de músicos y grupos que han dejado una huella indeleble en la historia de la música, desde leyendas como The Beatles y Michael Jackson hasta artistas contemporáneos como Beyoncé y Ed Sheeran.");
            subCategories.add(createSubCategory(subCategoryInDto));

            subCategoryInDto.setName("Álbumes y canciones icónicas");
            subCategoryInDto.setDescription("Sumérgete en los álbumes y canciones que han definido épocas y generaciones, desde clásicos como \"Thriller\" de Michael Jackson hasta éxitos contemporáneos como \"Despacito\" de Luis Fonsi.");
            subCategories.add(createSubCategory(subCategoryInDto));

            subCategoryInDto.setName("Historia de la música");
            subCategoryInDto.setDescription("Explora los hitos y momentos clave en la evolución de la música, desde los primeros instrumentos musicales hasta la era del streaming, pasando por la invención del vinilo, el surgimiento de la radio y la revolución digital.");
            subCategories.add(createSubCategory(subCategoryInDto));

            subCategoryInDto.setName("Teoría musical");
            subCategoryInDto.setDescription("Explora los fundamentos y conceptos esenciales que constituyen la teoría musical, desde la notación y la estructura de las composiciones hasta los elementos de armonía y ritmo.");
            subCategories.add(createSubCategory(subCategoryInDto));

            subCategoryInDto.setName("Entrenamiento Auditivo");
            subCategoryInDto.setDescription("Desarrolla tus habilidades auditivas y musicales mediante ejercicios diseñados para mejorar la capacidad de reconocer notas, intervalos, acordes y ritmos, fortaleciendo así tu percepción y comprensión de la música.");
            subCategories.add(createSubCategory(subCategoryInDto));

            category.setIdCategory(6);
            subCategoryInDto.setCategory(category);
            subCategoryInDto.setName("Géneros Literarios");
            subCategoryInDto.setDescription("Explora los diferentes estilos y tipos de escritura, como la poesía, la novela, el ensayo, el drama y la literatura infantil, entre otros.");
            subCategories.add(createSubCategory(subCategoryInDto));

            subCategoryInDto.setName("Autores Clásicos");
            subCategoryInDto.setDescription("Conoce a los escritores que han dejado una huella indeleble en la historia de la literatura, desde Shakespeare y Cervantes hasta Jane Austen y Tolstói.");
            subCategories.add(createSubCategory(subCategoryInDto));

            subCategoryInDto.setName("Movimientos Literarios");
            subCategoryInDto.setDescription("Aprende sobre los períodos y movimientos literarios, como el Romanticismo, el Realismo, el Modernismo y el Postmodernismo, entre otros.");
            subCategories.add(createSubCategory(subCategoryInDto));

            subCategoryInDto.setName("Obras Emblemáticas");
            subCategoryInDto.setDescription("Descubre obras literarias que han marcado época y que son consideradas fundamentales en la historia de la literatura mundial.");
            subCategories.add(createSubCategory(subCategoryInDto));

            subCategoryInDto.setName("Literatura Mundial");
            subCategoryInDto.setDescription("Explora la diversidad de la literatura a nivel global, destacando autores y obras representativas de diferentes culturas y tradiciones literarias.");
            subCategories.add(createSubCategory(subCategoryInDto));

            subCategoryInDto.setName("Crítica Literaria");
            subCategoryInDto.setDescription("Analiza las teorías y métodos utilizados para interpretar y evaluar obras literarias, así como el impacto de la crítica en la comprensión y apreciación de la literatura.");
            subCategories.add(createSubCategory(subCategoryInDto));

            category.setIdCategory(7);
            subCategoryInDto.setCategory(category);
            subCategoryInDto.setName("Deportes Olímpicos");
            subCategoryInDto.setDescription("Explora los deportes que forman parte del programa olímpico, sus reglas, historia y los atletas destacados que han competido en los Juegos Olímpicos.");
            subCategories.add(createSubCategory(subCategoryInDto));

            subCategoryInDto.setName("Fútbol");
            subCategoryInDto.setDescription("Aprende sobre el deporte más popular del mundo, incluyendo ligas, equipos destacados, torneos internacionales como la Copa del Mundo, y figuras legendarias del fútbol.");
            subCategories.add(createSubCategory(subCategoryInDto));

            subCategoryInDto.setName("Deportes de Motor");
            subCategoryInDto.setDescription("Descubre disciplinas como la Fórmula 1, MotoGP, rally, y otras competiciones de motor, así como los pilotos y equipos más exitosos en cada una.");
            subCategories.add(createSubCategory(subCategoryInDto));

            subCategoryInDto.setName("Baloncesto");
            subCategoryInDto.setDescription("Conoce la historia de este deporte, ligas como la NBA, equipos emblemáticos, reglas del juego, y grandes figuras que han dejado una marca en el baloncesto mundial.");
            subCategories.add(createSubCategory(subCategoryInDto));

            subCategoryInDto.setName("Tenis");
            subCategoryInDto.setDescription("Explora el mundo del tenis, incluyendo torneos Grand Slam, jugadores destacados, la historia del deporte, y las rivalidades más memorables en la cancha.");
            subCategories.add(createSubCategory(subCategoryInDto));

            subCategoryInDto.setName("Deportes Extremos");
            subCategoryInDto.setDescription("Aprende sobre deportes como el surf, snowboard, escalada, y otros que desafían los límites físicos y exploran entornos naturales extremos.");
            subCategories.add(createSubCategory(subCategoryInDto));


            category.setIdCategory(8);

            subCategoryInDto.setCategory(category);
            subCategoryInDto.setName("Ciencias Naturales");
            subCategoryInDto.setDescription("Explora disciplinas como la biología, la química, la física y la astronomía, aprendiendo sobre los principios fundamentales que rigen el universo natural.");
            subCategories.add(createSubCategory(subCategoryInDto));

            subCategoryInDto.setName("Tecnología Digital");
            subCategoryInDto.setDescription("Aprende sobre los avances en informática, internet, inteligencia artificial, y tecnologías emergentes como la realidad virtual y aumentada.");
            subCategories.add(createSubCategory(subCategoryInDto));

            subCategoryInDto.setName("Medicina y Salud");
            subCategoryInDto.setDescription("Descubre los desarrollos en medicina, biotecnología, genética, y las últimas investigaciones en tratamientos médicos y prevención de enfermedades.");
            subCategories.add(createSubCategory(subCategoryInDto));

            subCategoryInDto.setName("Innovaciones Tecnológicas");
            subCategoryInDto.setDescription("Conoce los inventos y descubrimientos que han transformado la sociedad, desde la invención de la electricidad hasta la era de la exploración espacial y más allá.");
            subCategories.add(createSubCategory(subCategoryInDto));

            subCategoryInDto.setName("Sostenibilidad y Medio Ambiente");
            subCategoryInDto.setDescription("Explora temas relacionados con el cambio climático, la conservación de recursos naturales, energías renovables, y la gestión sostenible de nuestro planeta.");
            subCategories.add(createSubCategory(subCategoryInDto));

            subCategoryInDto.setName("Historia de la Ciencia y Tecnología");
            subCategoryInDto.setDescription("Aprende sobre los hitos históricos y las figuras clave en el avance de la ciencia y la tecnología, desde la antigüedad hasta la era moderna.");
            subCategories.add(createSubCategory(subCategoryInDto));

            return subCategories;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
