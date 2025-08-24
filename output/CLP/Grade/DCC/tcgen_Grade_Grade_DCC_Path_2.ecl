:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Grade_Grade_DCC_Path_2(Score,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_number],

%domiain for int Type[Self_number, Score]#::(-32768)..32767,
%CLG Path Constrints,
(Score #< 0),
(Score #=< 100),
Result = 'illegalargumentexception',

%TypeVar Labeling Parts
labeling_int([Self_number, Score]).
