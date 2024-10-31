import { Comment } from "./comment.model";

export interface ArticleDetails {
    id: number;
    title: string;
    content: string;
    createdAt: Date;
    author: Date;
    theme: string;
    comments: Comment[]
}