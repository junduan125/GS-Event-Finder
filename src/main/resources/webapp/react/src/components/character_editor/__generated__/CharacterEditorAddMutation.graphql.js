/**
 * @flow
 */

/* eslint-disable */

'use strict';

/*::
import type { ConcreteRequest } from 'relay-runtime';
export type CharacterEditorAddMutationVariables = {|
  characterType: number,
  level?: ?number,
|};
export type CharacterEditorAddMutationResponse = {|
  +addUserCharacter: ?{|
    +username: string
  |}
|};
export type CharacterEditorAddMutation = {|
  variables: CharacterEditorAddMutationVariables,
  response: CharacterEditorAddMutationResponse,
|};
*/


/*
mutation CharacterEditorAddMutation(
  $characterType: Int!
  $level: Int
) {
  addUserCharacter(characterType: $characterType, level: $level) {
    username
  }
}
*/

const node/*: ConcreteRequest*/ = (function(){
var v0 = [
  {
    "defaultValue": null,
    "kind": "LocalArgument",
    "name": "characterType"
  },
  {
    "defaultValue": null,
    "kind": "LocalArgument",
    "name": "level"
  }
],
v1 = [
  {
    "alias": null,
    "args": [
      {
        "kind": "Variable",
        "name": "characterType",
        "variableName": "characterType"
      },
      {
        "kind": "Variable",
        "name": "level",
        "variableName": "level"
      }
    ],
    "concreteType": "GSUser",
    "kind": "LinkedField",
    "name": "addUserCharacter",
    "plural": false,
    "selections": [
      {
        "alias": null,
        "args": null,
        "kind": "ScalarField",
        "name": "username",
        "storageKey": null
      }
    ],
    "storageKey": null
  }
];
return {
  "fragment": {
    "argumentDefinitions": (v0/*: any*/),
    "kind": "Fragment",
    "metadata": null,
    "name": "CharacterEditorAddMutation",
    "selections": (v1/*: any*/),
    "type": "Mutation",
    "abstractKey": null
  },
  "kind": "Request",
  "operation": {
    "argumentDefinitions": (v0/*: any*/),
    "kind": "Operation",
    "name": "CharacterEditorAddMutation",
    "selections": (v1/*: any*/)
  },
  "params": {
    "cacheID": "5002d349b3dd6e4c0054445e5a30da52",
    "id": null,
    "metadata": {},
    "name": "CharacterEditorAddMutation",
    "operationKind": "mutation",
    "text": "mutation CharacterEditorAddMutation(\n  $characterType: Int!\n  $level: Int\n) {\n  addUserCharacter(characterType: $characterType, level: $level) {\n    username\n  }\n}\n"
  }
};
})();
// prettier-ignore
(node/*: any*/).hash = '80ba26e6e61580d72e5c736a4a859885';

module.exports = node;
