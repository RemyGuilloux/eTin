import { HttpHeaders } from '@angular/common/http';

export const config = {

    apiURI: 'http://localhost:1337/',
    httpOptions: {
        json: { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) },
        formUrlEncoded: { headers: new HttpHeaders({ 'Content-Type': 'application/x-www-form-urlencoded' }), }
    },
    grantType: 'password',
    clientId: 'eTin-web-app',
    title: 'eTin: First electronic Swear Tin online !'

};
