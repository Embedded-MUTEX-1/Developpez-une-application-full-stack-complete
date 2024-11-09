import { Theme } from "./theme.model";

export interface User {  
    id: number;
    email: string;
    name: string;
    password: string;
    themes: Theme[];
}