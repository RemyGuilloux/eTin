export class Token {
    accessToken: string;
    tokentType: string;
    refreshToken: string;
    expiresIn: number;
    scope: string;
    role: [ { authority: string } ];
    userId: number;

    constructor(accessToken: string,
                tokentType: string,
                refreshToken: string,
                expiresIn: number,
                scope: string,
                role: [ { authority: string } ],
                userId: number) {
            this.accessToken = accessToken;
            this.tokentType = tokentType;
            this.refreshToken = refreshToken;
            this.expiresIn = expiresIn;
            this.scope = scope;
            this.role = role;
            this.userId = userId;
    }

}
