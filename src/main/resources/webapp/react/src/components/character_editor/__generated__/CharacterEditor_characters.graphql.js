/**
 * @flow
 */

/* eslint-disable */

'use strict';

/*::
import type { ReaderFragment } from 'relay-runtime';
import type { FragmentReference } from "relay-runtime";
declare export opaque type CharacterEditor_characters$ref: FragmentReference;
declare export opaque type CharacterEditor_characters$fragmentType: CharacterEditor_characters$ref;
export type CharacterEditor_characters = {|
  +characters: ?$ReadOnlyArray<?{|
    +characterTypeID: ?number,
    +level: ?number,
  |}>,
  +$refType: CharacterEditor_characters$ref,
|};
export type CharacterEditor_characters$data = CharacterEditor_characters;
export type CharacterEditor_characters$key = {
  +$data?: CharacterEditor_characters$data,
  +$fragmentRefs: CharacterEditor_characters$ref,
  ...
};
*/


const node/*: ReaderFragment*/ = {
  "argumentDefinitions": [],
  "kind": "Fragment",
  "metadata": null,
  "name": "CharacterEditor_characters",
  "selections": [
    {
      "alias": null,
      "args": null,
      "concreteType": "UserCharacter",
      "kind": "LinkedField",
      "name": "characters",
      "plural": true,
      "selections": [
        {
          "alias": null,
          "args": null,
          "kind": "ScalarField",
          "name": "characterTypeID",
          "storageKey": null
        },
        {
          "alias": null,
          "args": null,
          "kind": "ScalarField",
          "name": "level",
          "storageKey": null
        }
      ],
      "storageKey": null
    }
  ],
  "type": "Query",
  "abstractKey": null
};
// prettier-ignore
(node/*: any*/).hash = '12435a9202062b8e7235c5479be14a18';

module.exports = node;
