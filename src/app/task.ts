export class Task {
    constructor(public taskId: number,
                public parentId: number,
                public priority: number,
                public startDate: Date,
                public taskDesk: string,
                public endDate?: Date
    ) {
    }
}
