# e-Tin Api V1

> This program provides a RESTFULL Api to handle functionalities needed for build IHM.
> Please follow the guide if you want to do your own request.
> Find below all ressources available:

## Common Ressources

> All this  ressources are included in the followings Entities: User -  Action* - Tinee*- Swear*

* > *[GET]*  "entities/ "  => _returns pageable containing all entities  in database_
* > *[GET]*  "entities/{id} "  => _returns  entity matching id._
* > *[POST]*  "entities/ {@Json: entity} "  => _create new entity in database._
* > *[PUT]**  "entities/{id} {@Json: entity} "  => _update given entity._
* > *[DELETE]**  "entities/{id} {@Json: entity} "  => _Delete the  entity._

 *Authentification required_

## Specific Ressources

### Users

* > *[GET]*  "Users/{id}/tinees"  => _returns user's tinees_
* > *[GET]*  "Users/{id}/swears"  => _returns user's swears_
* > *[POST]*  "Users/login"  => _returns  user's credentials_

## Tinees

* > *[GET]**  "Tinees/{id}/users/ "  => _returns pageable containing all  users into tinee._

* > *[GET]**  "Tinees/{id}/owner "  => _returns  owner of the tinee._

* > *[GET]**  "Tinees/{id}/active "  => _returns  boolean  depend on  state of the tinee._

* > *[GET]**  "Tinees/{id}/users/{id}/swears/ "  => _returns user's *own* swear into the tinee._

* > *[GET]**  "Tinees/{id}/users/{id}/swears/{id} "  => _returns user's specific swear into the tinee._

* > *[POST]**  "Tinees/{id}/users/{id} "  => _Add the given  user to the tinee._

* > *[DELETE]**  "Tinees/{id}/users/{id} "  => _Remove the given  user to the tinee._

* > *[POST]**  "Tinees/{id}/users/{id}/swears "  => _Report user's *own* swear into the tinee._

* > *[POST]**  "Tinees/{id}/users/{id}/reporter/{id}/swears "  => _Report *other* user's swear into the tinee._

* > *[PUT]**  "Tinees/{id}/users/{id}/swears/{id} "  => _Update user's *own* swear into the tinee._

_[...]* => Authentification required !_
