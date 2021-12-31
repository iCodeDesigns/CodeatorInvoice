This Package Contains
--------------------------------------------------------------------------------
1- com.taxdemo.www._2_0_0_systemIntegration.api._001_submit_document
2- com.taxdemo.www._2_0_0_systemIntegration.api._002_received_json
3- com.taxdemo.www._2_0_0_systemIntegration.api._003_creation_of_document_json

--------------------------------------------------------------------------------
( 1st ) / com.taxdemo.www._2_0_0_systemIntegration.api._001_submit_document :
    this package contain :
                    1- _200_Submit_Documents :
                            this class have a constructor get 3 parameters:

                                    - String token_type : 
                                        its value comes from the identity server 

                                    - String access_token : 
                                        its value comes from the identity server 

                                    - String json_of_submition_documents : 
                                        * use constructor in class [_201_Submit_Documents_003_json_generated_for_All_documents]
                                          from package [com.taxdemo.www._2_0_0_systemIntegration.api._003_creation_of_document_jason]
                                        * then get the generated json from the method [getDocuments_json_str]

**************************************************

( 2nd ) / com.taxdemo.www._2_0_0_systemIntegration.api._002_received_json :
    this package contain :
                    1- _101_Submit_Documents_JSON_000_ :
                        this class is a mirror for api json received when try to
                        submit document :
                                {
                                    "submissionId" : "",
                                    "acceptedDocuments" : [
                                                            {
                                                                "uuid":"",
                                                                "longId":"",
                                                                "internalId":"",
                                                                "hashKey":""
                                                            }
                                                          ],
                                    "rejectedDocuments" : [
                                                            {
                                                                "uuid":"",
                                                                "longId":"",
                                                                "internalId":"",
                                                                "hashKey":""
                                                            }
                                                          ]
                                }

                    2- _101_Submit_Documents_JSON_100_ :
                        this class is a mirror for the above json detail of 
                        [acceptedDocuments] or [rejectedDocuments] Object elements:
                                {
                                    "uuid":"",
                                    "longId":"",
                                    "internalId":"",
                                    "hashKey":""
                                }

**************************************************

( 3rd ) / com.taxdemo.www._2_0_0_systemIntegration.api._003_creation_of_document_json :
    this package contain :
                    1- _201_Submit_Documents_001_create_json_from_database :
                        this class used to :

                            * set documentTypeVersion >> 0.9 for pre-production api
                                                      >> 1.0 for production api
                              using class constructor

                            * use createJsonOfOneDocument method which takes one
                              argument which is [documentId] to get one document 
                              Data details from Database 

                    2- _201_Submit_Documents_002_json_generated_for_one_document :
                        this class used to :
                            Hold The generated data from the upper class [_201_Submit_Documents_001_create_json_from_database]
                            of only one document data ...
                            This class contain the following methods :
                                * getDocument_json_str_without_signature_element    : return String
                                * getDocument_json_object_without_signature_element : return java class object

                                * getDocument_json_str_with_signature_element    : return String
                                * getDocument_json_object_with_signature_element : return java class object

                    3- _201_Submit_Documents_003_json_generated_for_All_documents : 
                        this is the Very Important used class which is used to :
                            * call its constructor [_201_Submit_Documents_003_json_generated_for_All_documents]
                              which gets 3 parameters :
                                    - String documentTypeVersion    : >> 0.9 for pre-production api
                                                                      >> 1.0 for production api 

                                    - List<String> doucumentsIds    : all documents ids need to be collected and make it to json files

                                    - boolean includeNullParameters : >> true  : will include all null parameters in
                                                                      >> false : will not include null parameters in the
                            
                            * This class contain the following methods :
                                - getDocuments_json_str    : return String
                                - getDocuments_json_object : return java class object
                        
                                        
