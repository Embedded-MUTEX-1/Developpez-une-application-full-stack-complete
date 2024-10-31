import { Theme } from "./theme.model";

export interface User {  
    id: number;
    email: string;
    username: string;
    password: string;
    theme: Theme[];
}