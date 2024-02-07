# Exercices

1. Corriger le endpoint _PUT /phone/{id}_, qui doit permettre la mise à jour d'un téléphone.
2. Corriger le endpoint _GET /review/count_, qui doit permettre de retourner le nombre de reviews qui concernent un fabricant (_localhost:8080/review/count?manufacturer=Apple_).
3. Ajouter un endpoint _DELETE /review{id}_, qui doit permettre d'effacer une review selon son id.
4. Ajouter un endpoint _DELETE /consumer/{id}/review_, qui doit permettre d'effacer toutes les reviews d'un consommateur.
5. Modifier tous les endpoints du contrôleur _Consumer_ pour qu'ils retournent les objets reviews au complet en plus de leur nombre.
6. Ajouter une entite _Camera_ avec des attributs _name_ (_String_) et _resolution_ (_Integer_), ainsi qu'une relation _many to many_ avec l'entité _Phone_, et adapter la classe _Phone_ en conséquence.

# Objets JSON utiles

Consumer:
```
{
    "name": "John Doe",
    "email": "john.doe@gmail.com"
}
```

Phone:
```
{
    "manufacturer" : "LG",
    "model" : "W41 Pro"
}
```

Review:
```
{
    "comment" : "Trop cool ce phone",
    "rating" : 8,
    "consumerId": 1,
    "phoneId": 1
}
```