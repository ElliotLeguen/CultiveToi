package com.example.cultivetoioutubois.ui.theme.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.cultivetoioutubois.bo.Player
import kotlin.random.Random

@Composable
fun QuestionsScreen(navController: NavController, gameViewModel: GameViewModel) {
    // Liste des questions avec leur réponse et la difficulté (nombre de gorgées)
    val questions = listOf(
        "Quelle est la couleur du ciel ?" to "Bleu" to 1,
        "Combien de continents y a-t-il ?" to "7" to 1,
        "Quel est l'animal qui porte des rayures ?" to "Zèbre" to 1,
        "Qui est le créateur du manga 'One Piece' ?" to "Eiichiro Oda" to 3,
        "Quel est le nom du personnage principal dans 'Naruto' ?" to "Naruto Uzumaki" to 2,
        "En quelle année a eu lieu la Révolution française ?" to "1789" to 4,
        "Qui a découvert l'Amérique en 1492 ?" to "Christophe Colomb" to 2,
        "Quel groupe a chanté 'Bohemian Rhapsody' ?" to "Queen" to 3,
        "Quel est le nom du premier album de The Beatles ?" to "Please Please Me" to 4,
        "Qui est surnommée la 'Reine de la Pop' ?" to "Madonna" to 2,
        "Quel est le titre du film où l'on voit des dinosaures ressuscités ?" to "Jurassic Park" to 5,
        "Qui a réalisé 'Inception' ?" to "Christopher Nolan" to 5,
        "Dans quel jeu vidéo trouve-t-on des Pokémon ?" to "Pokémon" to 1,
        "Quel est le plus grand océan de la Terre ?" to "L'Océan Pacifique" to 6,
        "Quel est l'animal national de l'Australie ?" to "Kangourou" to 2,
        "Quel est le nom du personnage de 'Iron Man' ?" to "Tony Stark" to 2,
        "Qui est le père de la théorie de la relativité ?" to "Albert Einstein" to 4,
        "Quel est le nom du célèbre détective créé par Arthur Conan Doyle ?" to "Sherlock Holmes" to 3,
        "Dans quel pays a été inventé le papier ?" to "Chine" to 3,
        "Qui a écrit 'Les Misérables' ?" to "Victor Hugo" to 4,
        "Quel est le nom du vaisseau spatial du Capitaine Kirk ?" to "L'Enterprise" to 4,
        "En quelle année a eu lieu la Première Guerre mondiale ?" to "1914" to 5,
        "Quel est le nom du plus grand désert du monde ?" to "Le désert de l'Antarctique" to 6,
        "Qui a écrit 'Roméo et Juliette' ?" to "William Shakespeare" to 3,
        "Quelle est la capitale de l'Italie ?" to "Rome" to 1,
        "Quel est le nom de l'acteur principal dans 'Titanic' ?" to "Leonardo DiCaprio" to 3,
        "Quel est l'animal le plus rapide du monde ?" to "Le guépard" to 2,
        "Dans quel film voit-on un robot nommé R2-D2 ?" to "Star Wars" to 3,
        "Quel est le plus grand fleuve du monde ?" to "L'Amazone" to 6,
        "Qui a peint la Mona Lisa ?" to "Léonard de Vinci" to 4,
        "Combien de joueurs composent une équipe de football ?" to "11" to 1,
        "Quel est le nom du dieu de la guerre dans la mythologie romaine ?" to "Mars" to 2,
        "Quel est le plus grand pays du monde ?" to "La Russie" to 4,
        "Quel est le nom du personnage qui porte une bague magique dans 'Le Seigneur des Anneaux' ?" to "Frodon Sacquet" to 3,
        "Combien de pays composent l'Union européenne ?" to "27" to 4,
        "Quelle est la capitale du Canada ?" to "Ottawa" to 2,
        "Quel est le titre du premier film d'animation de Disney ?" to "Blanche-Neige et les Sept Nains" to 5,
        "Qui est l'inventeur de l'ampoule ?" to "Thomas Edison" to 4,
        "Quel est le nom du sorcier dans 'Harry Potter' ?" to "Harry Potter" to 2,
        "Quel est le pays d'origine de la pizza ?" to "Italie" to 2,
        "Quel est le nom de la fameuse ville engloutie ?" to "Atlantide" to 5,
        "En quelle année a eu lieu le débarquement en Normandie ?" to "1944" to 5,
        "Quel est le nom du vaisseau spatial dans '2001 : L'Odyssée de l'espace' ?" to "Discovery One" to 4,
        "Qui a écrit 'Le Petit Prince' ?" to "Antoine de Saint-Exupéry" to 3,
        "Quel est le plus grand musée du monde ?" to "Le Louvre" to 5,
        "Quelle est la formule chimique de l'eau ?" to "H2O" to 1,
        "Quel est l'élément chimique dont le symbole est 'O' ?" to "Oxygène" to 2,
        "Combien de pays composent l'Afrique ?" to "54" to 4,
        "Qui a réalisé 'Avatar' ?" to "James Cameron" to 5,
        "Quelle est la capitale de l'Espagne ?" to "Madrid" to 2,
        "Dans quel pays se trouve la grande muraille ?" to "Chine" to 4,
        "Quel est le nom de la série avec des zombies et des survivants ?" to "The Walking Dead" to 4,
        "Quel est l'animal qui fait le miel ?" to "L'abeille" to 2,
        "Qui a créé le personnage de Batman ?" to "Bob Kane" to 3,
        "Quel est le nom du personnage principal de 'Matrix' ?" to "Neo" to 3,
        "Quel est l'élément chimique de la formule NaCl ?" to "Chlore" to 3,
        "Quel est le nom de l'acteur de 'Jurassic Park' ?" to "Sam Neill" to 2,
        "Dans quel pays se trouve la pyramide de Gizeh ?" to "Égypte" to 3,
        "Quel est l'élément chimique de la formule NaCl ?" to "Sodium" to 3,
        "Quel est le nom du personnage principal dans 'The Witcher' ?" to "Geralt de Riv" to 3,
        "Quel est le nom de la plus grande île du monde ?" to "Greenland" to 6,
        "Quel est le nom du premier président des États-Unis ?" to "George Washington" to 4,
        "En quelle année l'homme a-t-il marché sur la Lune ?" to "1969" to 5,
        "Qui a inventé la machine à vapeur ?" to "James Watt" to 4,
        "Quel est l'animal symbole de la France ?" to "Le coq" to 2,
        "Dans quelle ville se trouve la Tour Eiffel ?" to "Paris" to 1,
        "Quel est l'élément chimique dont le symbole est 'Fe' ?" to "Fer" to 3,
        "Quel est le nom de la célèbre place de Londres ?" to "Trafalgar Square" to 4,
        "Qui a écrit 'Don Quichotte' ?" to "Miguel de Cervantes" to 5,
        "Quel est le sport où l'on joue avec un ballon ovale ?" to "Rugby" to 3,
        "Quel est le plus grand lac du monde ?" to "La mer Caspienne" to 6,
        "Quel est le symbole chimique du potassium ?" to "K" to 3,
        "Quel est le nom du navire du Titanic ?" to "RMS Titanic" to 3,
        "Dans quel pays se situe la ville de Kyoto ?" to "Japon" to 2,
        "Quel est le plus grand volcan actif du monde ?" to "Le Mauna Loa" to 6,
        "Qui a peint le plafond de la chapelle Sixtine ?" to "Michel-Ange" to 4,
        "Quel est l'organe principal du système circulatoire ?" to "Le cœur" to 2,
        "Quelle est la capitale de l'Allemagne ?" to "Berlin" to 2,
        "Qui a composé la musique de 'L'Odyssée' ?" to "Vangelis" to 5,
        "Quel est le nom de la ville dans le film 'Inception' ?" to "Paris" to 4,
        "Quel est le nom du robot dans 'Star Wars' ?" to "C-3PO" to 3,
        "En quelle année les premiers pas de l'homme ont été réalisés sur la Lune ?" to "1969" to 5,
        "Qui est l'inventeur du téléphone ?" to "Alexander Graham Bell" to 4,
        "Quel est le plus grand temple d'Angkor ?" to "Angkor Wat" to 5,
        "Qui a écrit '1984' ?" to "George Orwell" to 5,
        "Quel est le nom de la galaxie dans 'Star Wars' ?" to "La galaxie lointaine" to 3,
        "Qui a peint 'La Nuit étoilée' ?" to "Vincent van Gogh" to 4,
        "Quelle est la capitale du Japon ?" to "Tokyo" to 2,
        "Qui a écrit 'Le Seigneur des Anneaux' ?" to "J.R.R. Tolkien" to 4,
        "Dans quel pays se trouve le Machu Picchu ?" to "Pérou" to 4,
        "Quel est le plus grand animal terrestre ?" to "L'éléphant" to 2,
        "Quel est l'instrument utilisé pour mesurer la température ?" to "Thermomètre" to 1,
        "Quel est le premier élément du tableau périodique ?" to "Hydrogène" to 2,
        "Dans quel film trouve-t-on un personnage nommé 'Jack Dawson' ?" to "Titanic" to 2,
        "Quel est l'auteur de 'Les Trois Mousquetaires' ?" to "Alexandre Dumas" to 4,
        "Dans quel pays se trouve la Grande Muraille de Chine ?" to "Chine" to 3,
        "Quel est le nom de l'archipel au large du Japon ?" to "Les îles Ryūkyū" to 5,
        "Qui a peint 'Guernica' ?" to "Pablo Picasso" to 5,
        "Quel est le nom de la planète la plus proche du Soleil ?" to "Mercure" to 3,
        "Quel est l'instrument de musique à corde joué avec un archet ?" to "Violon" to 2,
        "Quel est le nom du premier homme dans l'espace ?" to "Youri Gagarine" to 5,
        "Qui a écrit 'Les Fleurs du mal' ?" to "Charles Baudelaire" to 4,
        "Quel est le plus grand oiseau du monde ?" to "L'autruche" to 2,
        "Quel est l'auteur de 'Les Misérables' ?" to "Victor Hugo" to 4,
        "Quel est le nom de la ville où se trouve la Tour de Pise ?" to "Pise" to 3,
        "Quelle est la capitale du Canada ?" to "Ottawa" to 3,
        "Qui a découvert la pénicilline ?" to "Alexander Fleming" to 4,
        "Quel est l'animal qui pond des œufs et vit en Australie ?" to "L'ornithorynque" to 4,
        "Quel est le nom de la plus grande île du monde ?" to "Groenland" to 6,
        "En quelle année a eu lieu la chute du mur de Berlin ?" to "1989" to 5,
        "Quel est le plus grand continent du monde ?" to "Asie" to 3,
        "Quel est l'élément chimique dont le symbole est 'Na' ?" to "Sodium" to 3,
        "Qui a écrit 'Cien años de soledad' ?" to "Gabriel García Márquez" to 5,
        "Quelle est la capitale de l'Australie ?" to "Canberra" to 4,
        "Quel est l'auteur de 'Le Comte de Monte-Cristo' ?" to "Alexandre Dumas" to 4,
        "Quel est le plus grand lac d'Afrique ?" to "Le lac Victoria" to 6,
        "Quel est le nom du compositeur de 'La Flûte enchantée' ?" to "Wolfgang Amadeus Mozart" to 5,
        "Quel est le nom de la plus grande forêt tropicale du monde ?" to "La forêt amazonienne" to 6,
        "Dans quel pays trouve-t-on les pyramides de Gizeh ?" to "Égypte" to 3,
        "Quelle est la capitale de l'Inde ?" to "New Delhi" to 3,
        "Quel est l'élément chimique de la formule H2O ?" to "Oxygène" to 2,
        "Quel est le pays d'origine du chocolat ?" to "Mexique" to 3,
        "Quel est le nom de la célèbre œuvre de Michel-Ange située à la chapelle Sixtine ?" to "Le Jugement Dernier" to 4,
        "Quel est le nom du dernier président de l'URSS ?" to "Mikhaïl Gorbatchev" to 5,
        "Quel est le nom du monstre marin dans 'Moby Dick' ?" to "La baleine blanche" to 4,
        "Quel est le nom du roman de George Orwell publié en 1949 ?" to "1984" to 5,
        "Dans quel film Disney trouve-t-on le personnage de Simba ?" to "Le Roi Lion" to 3,
        "Quel est le nom du bateau qui a sauvé les passagers du Titanic ?" to "Le Carpathia" to 5,
        "Quel est le nom de la ville où se trouvent les célèbres canaux ?" to "Venise" to 3,
        "Quel est le nom de l'auteur du livre 'L'Alchimiste' ?" to "Paulo Coelho" to 5,
        "Quel est le nom du président des États-Unis en 1865 ?" to "Abraham Lincoln" to 5,
        "Quel est le nom du dieu grec de la guerre ?" to "Arès" to 3,
        "Quel est le nom du super-héros avec un bouclier ?" to "Captain America" to 2,
        "Quel est l'instrument utilisé pour écouter de la musique ?" to "Un casque" to 1,
        "Quel est l'instrument de musique à vent utilisé dans les orchestres ?" to "Flûte" to 2,
        "Quel est le nom de la personne qui a écrit 'Le Petit Prince' ?" to "Antoine de Saint-Exupéry" to 3,
        "Quel est le sport qui se joue avec un ballon rond ?" to "Football" to 1,
        "Quelle est la capitale du Royaume-Uni ?" to "Londres" to 2,
        "Dans quel pays trouve-t-on les statues de l'île de Pâques ?" to "Chili" to 4,
        "Quel est le nom du bateau du capitaine Nemo dans 'Vingt mille lieues sous les mers' ?" to "Le Nautilus" to 5,
        "Quel est l'élément chimique dont le symbole est 'Au' ?" to "Or" to 3,
        "Quelle est la capitale de l'Allemagne ?" to "Berlin" to 2,
        "Quel est le nom du célèbre navire qui a coulé en 1912 ?" to "Titanic" to 3,
        "Qui a inventé la théorie de l'évolution ?" to "Charles Darwin" to 4,
        "Quel est le nom du film où les personnages vivent dans une simulation ?" to "Matrix" to 4,
        "Quel est le nom du créateur de Facebook ?" to "Mark Zuckerberg" to 3,
        "Quel est le premier président de la Cinquième République ?" to "Charles de Gaulle" to 4,
        "Quel est l'élément chimique dont le symbole est 'He' ?" to "Hélium" to 2,
        "Quel est le nom du héros grec de l'Iliade ?" to "Achille" to 3,
        "Quel est le nom du personnage principal dans 'Harry Potter' ?" to "Harry Potter" to 2,
        "Quel est le plus grand pays d'Amérique du Sud ?" to "Brésil" to 4,
        "Quel est le nom de l'architecte qui a conçu la Tour Eiffel ?" to "Gustave Eiffel" to 5,
        "Quel est le plus grand pays d'Asie ?" to "Chine" to 4,
        "Quel est le nom de l'élément chimique dont le symbole est 'Cl' ?" to "Chlore" to 3,
        "Quel est le nom de la première femme à avoir remporté le prix Nobel ?" to "Marie Curie" to 5,
        "Quel est le nom de la ville dans laquelle se trouve l'Empire State Building ?" to "New York" to 2,
        "Dans quelle ville se trouve le Colisée ?" to "Rome" to 3,
        "Quel est le nom du plus grand primate du monde ?" to "Le gorille" to 2,
        "Quel est l'élément chimique dont le symbole est 'N' ?" to "Azote" to 2,
        "Quel est le plus grand navire de guerre du monde ?" to "Le USS Enterprise" to 6,
        "Quel est le plus grand désert du monde ?" to "Le désert de l'Antarctique" to 6,
        "Quel est l'organe principal du système respiratoire ?" to "Les poumons" to 1,
        "Quel est le nom de l'auteur de 'Don Quichotte' ?" to "Miguel de Cervantes" to 5,
        "Qui a inventé la lampe à incandescence ?" to "Thomas Edison" to 4,
        "Quel est le plus grand fleuve du monde ?" to "L'Amazone" to 6,
        "Quel est le pays le plus peuplé du monde ?" to "Chine" to 2,
        "Dans quel pays se situe la ville de Marrakech ?" to "Maroc" to 3,
        "Qui est l'auteur de 'Harry Potter' ?" to "J.K. Rowling" to 4,
        "Quel est le plus grand pays d'Afrique ?" to "Algérie" to 4,
        "Quel est l'élément chimique dont le symbole est 'Fe' ?" to "Fer" to 3,
        "Quel est le nom de l'acteur principal dans 'Pirates des Caraïbes' ?" to "Johnny Depp" to 2,
        "Dans quel océan se trouve la grande barrière de corail ?" to "Océan Pacifique" to 5,
        "Quel est le nom du système solaire qui nous entoure ?" to "Système solaire" to 1,
        "Quel est le nom de la montagne la plus haute du monde ?" to "L'Everest" to 6,
        "Quel est le nom de la ville où se situe la Sagrada Familia ?" to "Barcelone" to 3,
        "Quel est l'instrument de musique utilisé dans le jazz ?" to "Saxophone" to 3,
        "Quel est le nom de la méthode de communication par signes utilisée par les sourds ?" to "Langue des signes" to 2,
        "Quel est le nom du plus grand volcan actif du monde ?" to "Le Mauna Loa" to 6,
        "Dans quel film trouve-t-on un personnage nommé 'Darth Vader' ?" to "Star Wars" to 2,
        "Quel est le nom de l'œuvre de Léonard de Vinci représentant un sourire mystérieux ?" to "La Joconde" to 5,
        "Dans quel pays peut-on visiter la ville de Petra ?" to "Jordanie" to 4,
        "Quel est le nom du plus grand lac d'Amérique du Sud ?" to "Le lac Titicaca" to 5,
        "Quel est le nom du célèbre auteur de 'Sherlock Holmes' ?" to "Arthur Conan Doyle" to 4,
        "Quel est le nom du célèbre peintre espagnol qui a créé le cubisme ?" to "Pablo Picasso" to 4,
        "Quel est le nom de l'acteur principal dans 'Forrest Gump' ?" to "Tom Hanks" to 2,
        "Dans quel pays trouve-t-on la ville de Sydney ?" to "Australie" to 3,
        "Quel est le nom du plus grand océan du monde ?" to "Océan Pacifique" to 6,
        "Quel est l'auteur du livre 'Le Petit Prince' ?" to "Antoine de Saint-Exupéry" to 3,
        "Quel est le nom du premier homme à avoir marché sur la Lune ?" to "Neil Armstrong" to 5,
        "Quel est le nom du plus grand théâtre du monde ?" to "Le Metropolitan Opera House" to 5,
        "Quel est le nom de la plus grande île de la mer Méditerranée ?" to "La Sicile" to 4,
        "Quel est le nom de l'instrument de musique composé de touches noires et blanches ?" to "Piano" to 2,
        "Quel est le plus grand continent en termes de superficie ?" to "Asie" to 3,
        "Qui a peint 'La Cène' ?" to "Léonard de Vinci" to 4,
        "Quel est le nom du film avec un robot nommé 'R2-D2' ?" to "Star Wars" to 3,
        "Quel est le plus grand producteur de pétrole au monde ?" to "États-Unis" to 5,
        "Quel est l'auteur de '1984' ?" to "George Orwell" to 4,
        "Quel est le nom de la mer qui borde la Grèce ?" to "Mer Méditerranée" to 3,
        "Quel est le nom du premier président des États-Unis ?" to "George Washington" to 4,
        "Quel est le nom de la ville d'origine du sushi ?" to "Tokyo" to 3,
        "Quel est le nom du plus grand fleuve d'Afrique ?" to "Le Nil" to 5,
        "Dans quel pays peut-on visiter les pyramides de Gizeh ?" to "Égypte" to 4,
        "Quel est le nom du plus grand pays de l'Union européenne ?" to "France" to 4,
        "Quel est le nom du dieu égyptien de la mort ?" to "Osiris" to 3,
        "Quel est le nom du film où l'on voit des jouets qui prennent vie ?" to "Toy Story" to 3,
        "Quel est le nom du plus grand océan de la Terre ?" to "Océan Pacifique" to 6,
        "Quel est l'animal emblématique de l'Afrique ?" to "Lion" to 3,
        "Dans quel pays trouve-t-on le Taj Mahal ?" to "Inde" to 3,
        "Quel est l'élément chimique dont le symbole est 'Na' ?" to "Sodium" to 3,
        "Qui est l'auteur de 'Le Comte de Monte-Cristo' ?" to "Alexandre Dumas" to 4,
        "Quel est le nom du plus grand homme préhistorique ?" to "Gigantopithèque" to 5,
        "Quel est le nom de la ville qui abrite l'Arc de Triomphe ?" to "Paris" to 2,
        "Quel est le nom de la montagne sacrée des Japonais ?" to "Mont Fuji" to 4,
        "Quel est le nom de l'île où se trouve la Statue de la Liberté ?" to "Liberty Island" to 5,
        "Quel est le nom du plus grand désert chaud du monde ?" to "Le Sahara" to 6,
        "Quel est le nom du personnage principal de 'Le Hobbit' ?" to "Bilbo Baggins" to 3,
        "Dans quel pays trouve-t-on la ville de Saint-Pétersbourg ?" to "Russie" to 4,
        "Quel est le nom du plus grand pont suspendu du monde ?" to "Pont Akashi-Kaikyō" to 6,
        "Quel est le nom de la plus grande pyramide d'Égypte ?" to "Pyramide de Gizeh" to 5,
        "Quel est le nom du volcan le plus actif d'Italie ?" to "L'Etna" to 4,
        "Quel est le nom de la capitale de la Suisse ?" to "Berne" to 3,
        "Quel est le nom de l'élément chimique dont le symbole est 'Ag' ?" to "Argent" to 3,
        "Quel est le nom du plus grand mammifère marin ?" to "La baleine bleue" to 6,
        "Quel est le nom de l'auteur de 'Frankenstein' ?" to "Mary Shelley" to 4,
        "Quel est le nom de la plus grande ville du monde en termes de population ?" to "Tokyo" to 2
    )


    var randomQuestionIndex by remember { mutableStateOf(Random.nextInt(questions.size)) }
    val (questionAnswerPair, difficulty) = questions[randomQuestionIndex]
    val (question, correctAnswer) = questionAnswerPair

    // Sélectionne un joueur aléatoire parmi la liste des joueurs
    var randomPlayer by remember { mutableStateOf(gameViewModel.players.randomOrNull()) }

    // Variable d'état pour afficher ou non la réponse
    var showAnswer by remember { mutableStateOf(false) }

    // Lorsqu'on clique sur la question, change de question et de joueur
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .clickable {
                if (showAnswer) {
                    randomQuestionIndex = Random.nextInt(questions.size) // Changer la question
                    randomPlayer = gameViewModel.players.randomOrNull() // Changer de joueur
                    showAnswer = false  // Cacher la réponse
                } else {
                    showAnswer = true  // Afficher la réponse
                }
            }
    ) {
        // Affichage du joueur
        Text(
            text = "Question pour ${randomPlayer?.pseudo ?: "Un joueur"}",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Affichage de la question
        Text(
            text = question,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Affichage de la réponse et de la difficulté
        if (showAnswer) {
            // Affichage du nombre de gorgées
            Text(
                text = "Tu bois $difficulty gorgée(s) !",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Blue,
                modifier = Modifier
                    .background(Color(0xFFE0F7FA)) // Couleur de fond
                    .padding(8.dp)
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            // Affichage de la réponse correcte
            Box(
                modifier = Modifier
                    .background(Color(0xFFD1C4E9)) // Fond violet clair
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "Réponse : $correctAnswer",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Black,
                )
            }
        }
    }
}
