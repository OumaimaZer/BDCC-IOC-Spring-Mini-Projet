# Mini-Projet : Framework d’Injection de Dépendances — Jeu RPG
## Objectif du Projet
Ce mini-projet a pour but de simuler un jeu de combat RPG (joueur vs monstre) en appliquant les concepts de l’inversion de contrôle (IoC) et de l’injection de dépendances (DI), en suivant strictement l’architecture utilisée dans le TP avec Mohamed Youssfi :
        dao, ext, metier, pres

## Structure du projet
- dao : contient les interfaces IPlayerDao et IMonsterDao pour définir les actions du joueur et les caractéristiques du monstre.
- ext : contient les implémentations concrètes comme PlayerDaoImpl, MonsterDaoImpl ainsi qu'une nouvelle version de celles-ci destinée à la configuration XML.
- metier : contient la logique métier dans GameEngineImpl, qui utilise les DAO pour gérer le combat.
- pres : contient les classes de présentation (GameLauncher, GameUI, GameMenu, etc.) permettant d’interagir avec l’utilisateur.

## Approches d’injection utilisées
Le projet a été conçu pour illustrer plusieurs styles d'injection de dépendances, permettant de comparer les différentes méthodes prises en charge par un framework de type Spring.

### 1. Injection via les annotations Spring
Utilisation de @Service, @Repository, @Component

Les DAO (PlayerDaoImpl, MonsterDaoImpl) sont injectés automatiquement dans GameEngineImpl.

@Primary est utilisé pour indiquer l'implémentation par défaut à utiliser lorsque plusieurs beans sont disponibles.

### 2. Injection manuelle (dynamique)
Dans certaines classes comme GameMain, les DAO sont instanciés manuellement :
*IPlayerDao playerDao = new PlayerDaoImpl();
IMonsterDao monsterDao = new MonsterDaoImpl();
GameEngineImpl game = new GameEngineImpl(playerDao, monsterDao);*
Cette approche est utile pour le test rapide sans passer par un conteneur Spring.

### 3. Injection par annotation
  Configuration par scanning des packages grâce à @ComponentScan
-  Injection automatique via @Autowired dans GameEngineImpl
-  Utilisation de @Primary pour définir les implémentations par défaut
-  Toutes les classes nécessaires (DAO, UI, menu, moteur) sont annotées avec :
-  @Component, @Repository, ou @Service selon leur rôle

*ApplicationContext context =
   new AnnotationConfigApplicationContext("net.zerhouani");

IPlayerDao playerDao = context.getBean(IPlayerDao.class);
IMonstreDao monsterDao = context.getBean(IMonstreDao.class);*

-  C’est l’approche principale pour un projet moderne utilisant Spring sans fichier XML.

### 4. Injection par configuration XML
Une deuxième version de PlayerDaoImpl et MonsterDaoImpl a été ajoutée pour l’approche XML (fichier applicationContext.xml).

Ces versions sont déclarées comme beans dans le fichier XML, et injectées dans GameEngineImpl.

## Fonctionnalités du jeu
Le joueur doit réussir un certain nombre d’actions aléatoires pour vaincre un monstre.
Liste des actions possibles : attaquer, défendre, se soigner, fuir.
L’interface console affiche les messages de progression, de succès ou d’échec, et la victoire finale.


## Résultats du projet :
### Version 1:
![image](https://github.com/user-attachments/assets/80b76f43-0366-4156-96c6-7b0a0c0c9e88)
![image](https://github.com/user-attachments/assets/22dca5e7-f1ac-4692-9cc4-33f89ad94a44)

### Version 2:
![image](https://github.com/user-attachments/assets/08994129-90c2-4240-90f4-fc96e6528c8d)
![image](https://github.com/user-attachments/assets/00444e05-76f4-469e-8e0a-c08e29526d0f)


## Conclusion
Ce mini-projet RPG constitue une excellente base pédagogique pour comprendre les mécanismes d’un conteneur Spring, tout en mettant en pratique les modèles de conception orientés objet comme l’injection de dépendance. Grâce aux multiples versions de DAO et aux trois types d’injection, il permet une comparaison concrète des avantages de chaque approche.


