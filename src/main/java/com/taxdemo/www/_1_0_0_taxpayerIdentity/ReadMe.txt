This Package Contains
--------------------------------------------------------------------------------
1- com.taxdemo.www._1_0_0_taxpayerIdentity.api._001_login_to_api
2- com.taxdemo.www._1_0_0_taxpayerIdentity.api._002_received_json

--------------------------------------------------------------------------------
( 1st ) / com.taxdemo.www._1_0_0_taxpayerIdentity.api._001_login_to_api :
    this package contain :
                    1- _100_Login_as_Taxpayer_System :
                            this class have a constructor get 3 parameters:

                                    - String Client_id : 
                                        its value comes from the Taxpayer Portal site

                                    - String Client_secret : 
                                        its value comes from the Taxpayer Portal site

**************************************************

( 2nd ) / com.taxdemo.www._1_0_0_taxpayerIdentity.api._002_received_json :
    this package contain :
                    1- _100_Login_as_Taxpayer_System_jsonFile_000_ :
                        this class is a mirror for api json received when try to
                        login :
                            - valid login
                                {
                                    "access_token" : "",
                                    "expires_in" : 0,
                                    "token_type" : "",
                                    "scope" : ""
                                }
                            - invalid login
                                {
                                    "error" : ""
                                }