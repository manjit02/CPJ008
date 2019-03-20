import { Pipe, PipeTransform } from '@angular/core';
import { Task } from '../task';


@Pipe({
  name: 'filterpipe',
  pure: false
})
export class FilterPipe implements PipeTransform {

  public transform(items: Task[], input: string, input1: number): any {
  //  if (values && values.length) {
    if (items && items !== undefined) {
      //console.log("in filter " + typeof items + JSON.stringify(items));
      //return items.filter(item => item.taskDesk.indexOf(input) !== -1);
      return items.filter(item => { if (input1 && item.taskId === input1) {return true;}
                                  if (input !== '' && item.taskDesk.indexOf(input) !== -1) {return true;}

      });
    } else {
      return items;
    }
  }

}
