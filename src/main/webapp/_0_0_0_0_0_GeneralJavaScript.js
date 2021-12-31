/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function isIntegerNumber(elem) {
    if (new RegExp(/^\d*\$/).test(elem)) {
        return true;
    } else {
        return false;
    }
}



