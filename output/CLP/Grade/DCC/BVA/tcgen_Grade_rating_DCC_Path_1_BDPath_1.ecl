:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Grade_rating_DCC_Path_1_BDPath_1(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_number],


%domiain for int Type[Self_number]#::(-32768)..32767,
%CLG Path Constrints,
(Self_number #= 0),
(Self_number #=< 100),
(Self_number #=< 59),
(Result = 'F'),

%TypeVar Labeling Parts
labeling_int([Self_number]).
